package com.example.shopkeeper.Order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.shopkeeper.HomeScreen.HomeScreenActivity;
import com.example.shopkeeper.R;
import com.example.shopkeeper.RecentOrder;
import com.example.shopkeeper.RecentOrderAdapter;
import com.example.shopkeeper.Remote.AndroidVersion;
import com.example.shopkeeper.ShippingAdapter;
import com.example.shopkeeper.ShippingModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Shipping extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private Button btngotoPlaceOrder;
    private Button addCustomer;
    private SearchView shipping_search;
    private List<ShippingModel> shippingModels = new ArrayList<>();
    private ShippingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        addCustomer = findViewById(R.id.btnaddcustomer);
        btngotoPlaceOrder = findViewById(R.id.btngotoplaceorder);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        shipping_search = findViewById(R.id.menu_search);
        mAdapter = new ShippingAdapter(shippingModels);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        shippingList();


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

    private void shippingList() {
        ShippingModel shippingModel = new ShippingModel("Hidden Brains infotech pvt ltd","Nirav",
                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380008",
                "India","9090946464","hiddenbrains@hotmail.com");
        shippingModels.add(shippingModel);
        shippingModel = new ShippingModel("Seven Seas infotech pvt. ltd.","Krupal",
                "Mehta","Jodhpur Char rasta","Ahmedabad","Gujarat","380010",
                "India","9090946464","hiddenbrains@hotmail.com");
        shippingModels.add(shippingModel);
        shippingModel = new ShippingModel("Kaizen infocomm pvt. ltd.","Mukul",
                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380020",
                "India","9090946464","hiddenbrains@hotmail.com");
        shippingModels.add(shippingModel);
        shippingModel = new ShippingModel("Hidden Brains infotech pvt ltd","Nirav",
                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380008",
                "India","9090946464","hiddenbrains@hotmail.com");
        shippingModels.add(shippingModel);
        shippingModel = new ShippingModel("Seven seas infotech pvt. ltd.","Krupal",
                "Mehta","Jodhpur Char rasta","Ahmedabad","Gujarat","380010",
                "India","9090946464","hiddenbrains@hotmail.com");
        shippingModels.add(shippingModel);
        shippingModel = new ShippingModel("Kaizen infocomm pvt. ltd.","Mukul",
                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380020",
                "India","9090946464","hiddenbrains@hotmail.com");
        shippingModels.add(shippingModel);

    }


}

