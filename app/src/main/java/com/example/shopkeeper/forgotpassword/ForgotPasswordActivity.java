package com.example.shopkeeper.forgotpassword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.MainActivity;
import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.forgotpassword.request.ForgotPassEmailRequestBody;
import com.example.shopkeeper.forgotpassword.request.ForgotPassRequestEnvelope;
import com.example.shopkeeper.forgotpassword.response.ForgotPasswordResponseEnvelope;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
    private Button sendResetPassLink;
    private EditText etForgotPasswordEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        sendResetPassLink = findViewById(R.id.btnforget);
        etForgotPasswordEmail = findViewById(R.id.etforgotemail);
        sendResetPassLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etForgotPasswordEmail.getText().toString().trim();
                if(email.isEmpty()){
                    etForgotPasswordEmail.requestFocus();
                    etForgotPasswordEmail.setError("Email Can not be empty");
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etForgotPasswordEmail.requestFocus();
                    etForgotPasswordEmail.setError("Please Enter Valid Email");
                }
                else{
                    sendResetLink();
                }
            }
        });

    }

    private void sendResetLink() {
        ForgotPassRequestEnvelope requestEnvelope = new ForgotPassRequestEnvelope();
        ForgotPassEmailRequestBody requestBody = new ForgotPassEmailRequestBody();
        ForgotPassEmailRequestBody.RequestForgotPassEmail requestModel = new ForgotPassEmailRequestBody.RequestForgotPassEmail();
        requestModel.emailID = etForgotPasswordEmail.getText().toString();
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestForgotPassEmail = requestModel;
        requestEnvelope.body = requestBody;
        Call<ForgotPasswordResponseEnvelope> call =
                RetrofitGenerator.getApiService().forgotPasswordEmailX(requestEnvelope);
        call.enqueue(new Callback<ForgotPasswordResponseEnvelope>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponseEnvelope> call, Response<ForgotPasswordResponseEnvelope> response) {
                Toast.makeText(ForgotPasswordActivity.this, "Email has been Sent", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<ForgotPasswordResponseEnvelope> call, Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this, "Email is not Matched", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
