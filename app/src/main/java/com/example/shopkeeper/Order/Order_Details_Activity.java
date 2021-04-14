package com.example.shopkeeper.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shopkeeper.Home;
import com.example.shopkeeper.R;

public class Order_Details_Activity extends AppCompatActivity {
    private Button btnsendInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__details_);
        btnsendInvoice = findViewById(R.id.btnsendinvoice);
        btnsendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Order_Details_Activity.this, Home.class);
                startActivity(i);
                Toast.makeText(Order_Details_Activity.this, "Invoice Sent", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}