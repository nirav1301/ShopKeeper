package com.example.shopkeeper.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopkeeper.R;
import com.example.shopkeeper.findcustomer.Shipping;

public class CreateOrder extends AppCompatActivity {
private Button btnGotoShipping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        getSupportActionBar().hide();
        btnGotoShipping = findViewById(R.id.btngotoshipping);
        btnGotoShipping.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateOrder.this, Shipping.class);
                startActivity(intent);
            }
        });
    }
}