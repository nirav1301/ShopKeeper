package com.example.shopkeeper.HomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.authentication.MainActivity;
import com.example.shopkeeper.Order.OrderHistory;
import com.example.shopkeeper.Order.Scanner;
import com.example.shopkeeper.R;
import com.example.shopkeeper.Remote.AndroidVersion;
import com.example.shopkeeper.Remote.ApiInterface;
import com.example.shopkeeper.Remote.JSONResponse;
import com.example.shopkeeper.databinding.ActivityHomeScreenBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeScreenActivity extends AppCompatActivity {

    private ArrayList<AndroidVersion> data;
    private recadapter adapter;
    private ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);
        getSupportActionBar().hide();

        initViews();
        binding.bottomNavigation.setOnNavigationItemSelectedListener(
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

    public void initViews() {

        binding.orderrecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.orderrecycler.setLayoutManager(layoutManager);
        loadJSON();
    }

    public void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface request = retrofit.create(ApiInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new recadapter(data);
                binding.orderrecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });
    }


    public void logout(View view) {
        Intent intent = new Intent(HomeScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}