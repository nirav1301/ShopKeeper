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

public class Scanner extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(Scanner.this,
                                HomeScreenActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.scan:
                        Intent intent1 = new Intent(Scanner.this,
                                Scanner.class);
                        startActivity(intent1);
                        break;
                    case R.id.order:
                        Intent intent2 = new Intent(Scanner.this
                                , OrderHistory.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }
}