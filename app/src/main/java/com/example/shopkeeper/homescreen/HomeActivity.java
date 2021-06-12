package com.example.shopkeeper.homescreen;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.shopkeeper.R;
import com.example.shopkeeper.ScannerFragment;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.findcustomer.FindCustomerModel;
import com.example.shopkeeper.orderhistory.OrderHistoryFragment;
import com.example.shopkeeper.recentorder.RecentOrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private ArrayList<CreateOrderModel> items;
    private FindCustomerModel customerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadFragment(new RecentOrderFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        items = (ArrayList<CreateOrderModel>) getIntent().getSerializableExtra("items");
        customerModel = (FindCustomerModel) getIntent().getSerializableExtra("customer");

    }
    public boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home:
                fragment = new RecentOrderFragment();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("items",items);
//                bundle.putSerializable("customer",customerModel);
//                fragment.setArguments(bundle);
                break;

            case R.id.scan:
                fragment = new ScannerFragment();
                break;

            case R.id.order:
                fragment = new OrderHistoryFragment();
                break;

        }

        return loadFragment(fragment);

    }
}