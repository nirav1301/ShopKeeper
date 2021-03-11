package com.example.shopkeeper.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shopkeeper.R;

public class CreateOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();
    }
}