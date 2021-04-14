package com.example.shopkeeper.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopkeeper.Home;
import com.example.shopkeeper.HomeScreen.HomeScreenActivity;
import com.example.shopkeeper.R;
import com.example.shopkeeper.Remote.APIClient;
import com.example.shopkeeper.Remote.LoginRequest;
import com.example.shopkeeper.Remote.LoginResponse;
import com.wang.avi.AVLoadingIndicatorView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText logEmail;
    private EditText logPassword;
    private Button btnLogin;
    private TextView txtForgot;
    private AVLoadingIndicatorView AVI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logEmail = findViewById(R.id.logemail);
        AVI = findViewById(R.id.avi);
        logPassword = findViewById(R.id.logpswd);
        btnLogin = findViewById(R.id.btnlogin);
        txtForgot = findViewById(R.id.txtforgot);
        stopAnim();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   String email = logEmail.getText().toString().trim();
                   String password = logPassword.getText().toString().trim();
                   if(email.isEmpty()){
                       logEmail.requestFocus();
                       logEmail.setError("Email cannot be empty");
                       return;
                   }
                   else if(! Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                       logEmail.requestFocus();
                       logEmail.setError("Enter valid email");
                       return;
                   }
                   else if(password.isEmpty()){
                       logPassword.requestFocus();
                       logPassword.setError("password cannot be empty");
                       return;
                   }
                   else{
                       startAnim();
                       userLogin();

                   }






            }
        });
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {
        LoginRequest loginRequest = new LoginRequest();
         loginRequest.setEmail(logEmail.getText().toString());
         loginRequest.setPassword(logPassword.getText().toString());
         Call<LoginResponse> loginResponseCall = APIClient.getService().loginUser(loginRequest);
         loginResponseCall.enqueue(new Callback<LoginResponse>() {
             @Override
             public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                 if(response.isSuccessful()){
                     Toast.makeText(MainActivity.this,
                             "Login Successful", Toast.LENGTH_LONG).show();
                     LoginResponse loginResponse = response.body();
                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             Intent intent = new Intent(MainActivity.this,
                                     Home.class);
                             startActivity(intent);
                             finish();

                         }
                     },700);

                 }
             }

             @Override
             public void onFailure(Call<LoginResponse> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "Network Failed", Toast.LENGTH_SHORT).show();

             }
         });

    }
    void startAnim(){
        AVI.show();
        // or avi.smoothToShow();
    }
    void stopAnim() {
        AVI.hide();
        // or avi.smoothToHide();

    }
    }