package com.example.shopkeeper.HomeScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.shopkeeper.Authentication.MainActivity;
import com.example.shopkeeper.Order.OrderHistory;
import com.example.shopkeeper.Order.Scanner;
import com.example.shopkeeper.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

import org.jetbrains.annotations.NotNull;

public class HomeScreenActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView orderRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();
        //askdjashdka
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                return true;
                            case R.id.scan:
                                Intent intent1 = new Intent(HomeScreenActivity.this,
                                        Scanner.class);
                                startActivity(intent1);
                                break;
                            case R.id.order:
                               Intent intent2 = new Intent(HomeScreenActivity.this
                               , OrderHistory.class);
                               startActivity(intent2);
                               break;
                        }
                        return false;
                    }
                }
        );

    }




    public void logout(View view){
        Intent intent = new Intent(HomeScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}