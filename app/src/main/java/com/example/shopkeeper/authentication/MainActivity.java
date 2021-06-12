package com.example.shopkeeper.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopkeeper.authentication.login.request.LoginRequestBody;
import com.example.shopkeeper.authentication.login.request.LoginRequestEnvelope;
import com.example.shopkeeper.authentication.login.response.LoginResponseEnvelope;
import com.example.shopkeeper.authentication.login.response.UserLoginResponse;
import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.homescreen.HomeActivity;
import com.example.shopkeeper.R;
import com.example.shopkeeper.forgotpassword.ForgotPasswordActivity;
import com.google.gson.Gson;
import com.wang.avi.AVLoadingIndicatorView;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText logEmail;
    private EditText logPassword;
    private CircularProgressButton btnLogin;
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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logEmail.getText().toString().trim();
                String password = logPassword.getText().toString().trim();
                if (email.isEmpty()) {
                    logEmail.requestFocus();
                    logEmail.setError("Email cannot be empty");
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    logEmail.requestFocus();
                    logEmail.setError("Enter valid email");
                    return;
                } else if (password.isEmpty()) {
                    logPassword.requestFocus();
                    logPassword.setError("password cannot be empty");
                    return;
                } else {
                    startAnim();
                    userLogin();

                }


            }
        });
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {

        LoginRequestEnvelope requestEnvelope = new LoginRequestEnvelope();
        LoginRequestBody requestBody = new LoginRequestBody();
        LoginRequestBody.RequestUserLogin requestModel = new LoginRequestBody.RequestUserLogin();
        requestModel.loginId = logEmail.getText().toString();
        requestModel.password = logPassword.getText().toString();
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestUserLogin = requestModel;
        requestEnvelope.body = requestBody;
        Call<LoginResponseEnvelope> call =
                RetrofitGenerator.getApiService().validateUserX(requestEnvelope);
        call.enqueue(new Callback<LoginResponseEnvelope>() {
            @Override
            public void onResponse(Call<LoginResponseEnvelope> call, Response<LoginResponseEnvelope> response) {
                Gson gson = new Gson();
                UserLoginResponse userLoginResponse = gson.fromJson(response.body().body.loginResponseModel.ValidateUserResult, UserLoginResponse.class);
                if (userLoginResponse.getSetting().getSuccess() == true) {
                     stopAnim();
//                    Toast.makeText(MainActivity.this,userLoginResponse.getData().get(0).getCompanyEmail(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Welcome" + " " + userLoginResponse.getData().get(0).getFirstName(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponseEnvelope> call, Throwable t) {

            }
        });



    }

    void startAnim() {
        btnLogin.startAnimation();
        // or avi.smoothToShow();
    }

    void stopAnim() {
        btnLogin.revertAnimation();
        // or avi.smoothToHide();

    }
}