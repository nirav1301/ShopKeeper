package com.example.shopkeeper.Order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shopkeeper.HomeScreen.HomeScreenActivity;
import com.example.shopkeeper.R;
import com.example.shopkeeper.Remote.AndroidVersion;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Shipping extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private TextView alertmessageShipping;
    private Button btngotoPlaceOrder;
    private Button addCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        getSupportActionBar().hide();
        addCustomer = findViewById(R.id.btnaddcustomer);
        btngotoPlaceOrder = findViewById(R.id.btngotoplaceorder);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        alertmessageShipping = (TextView)findViewById(R.id.emptyalertshipping);

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home:
//                        Intent intent = new Intent(Shipping.this,
//                                HomeScreenActivity.class);
//                        startActivity(intent);
//                        break;
//                    case R.id.scan:
//                        Intent intent1 = new Intent(Shipping.this,
//                                Scanner.class);
//                        startActivity(intent1);
//                        break;
//                    case R.id.order:
//                        Intent intent2 = new Intent(Shipping.this
//                                , OrderHistory.class);
//                        startActivity(intent2);
//                        break;
//                }
//                return false;
//            }
//        });
        btngotoPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shipping.this,PlaceOrder.class);
                startActivity(intent);

            }
        });
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shipping.this,AddCustomer.class);
                startActivity(intent);
            }
        });

    }



}

