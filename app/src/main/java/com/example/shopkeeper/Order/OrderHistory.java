package com.example.shopkeeper.Order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.shopkeeper.HomeScreen.HomeScreenActivity;
import com.example.shopkeeper.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class OrderHistory extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        getSupportActionBar().hide();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(OrderHistory.this,
                                HomeScreenActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.scan:
                        Intent intent1 = new Intent(OrderHistory.this,
                                Scanner.class);
                        startActivity(intent1);
                        break;
                    case R.id.order:
                       return true;
                }
                return false;
            }
        });
    }

}