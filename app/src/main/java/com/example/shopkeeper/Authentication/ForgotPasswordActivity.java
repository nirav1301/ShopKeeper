package com.example.shopkeeper.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shopkeeper.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText etForgot;
    private Button btnForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etForgot = findViewById(R.id.etforgotemail);
        btnForgot = findViewById(R.id.btnforget);
        getSupportActionBar().hide();
        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etForgot.getText().toString().trim();
                if(email.isEmpty()){
                    etForgot.requestFocus();
                    etForgot.setError("email cannot be empty");
                    return;
                }
               else if(! Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etForgot.requestFocus();
                    etForgot.setError("email is not valid");
                    return;
                }
               else{
                    sendResetLink();
                }

            }
        });
    }

    private void sendResetLink() {
        Toast.makeText(this, "Link has been sent", Toast.LENGTH_SHORT).show();
    }
}