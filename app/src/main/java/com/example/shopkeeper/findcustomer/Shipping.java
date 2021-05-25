package com.example.shopkeeper.findcustomer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.Order.AddCustomer;
import com.example.shopkeeper.Order.PlaceOrder;
import com.example.shopkeeper.R;
import com.example.shopkeeper.findcustomer.Request.FindCustomerRequestBody;
import com.example.shopkeeper.findcustomer.Request.FindCustomerRequestEnvelope;
import com.example.shopkeeper.findcustomer.Response.FindCustomerResponseEnvelope;
import com.google.gson.Gson;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Shipping extends AppCompatActivity {
//    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Button btngotoPlaceOrder;
    private Button addCustomer;
    private SearchView shipping_search;
//    private List<ShippingModel> shippingModels = new ArrayList<>();
    private XShippingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        addCustomer = findViewById(R.id.btnaddcustomer);
        btngotoPlaceOrder = findViewById(R.id.btngotoplaceorder);
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        shipping_search = findViewById(R.id.menu_search);
        swipeRefreshLayout = findViewById(R.id.swipeforrefshipping);
        mAdapter = new XShippingAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        AddShipping();
        mAdapter.setRecyclerViewItemClick(new EasyAdapter.OnRecyclerViewItemClick<FindCustomerModel>() {
            @Override
            public void onRecyclerViewItemClick(View view, FindCustomerModel model) {
                Toast.makeText(Shipping.this, "Data Printed", Toast.LENGTH_SHORT).show();

            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                AddShipping();
            }
        });



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
                Intent intent = new Intent(Shipping.this, PlaceOrder.class);
                startActivity(intent);

            }
        });
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shipping.this, AddCustomer.class);
                startActivity(intent);
            }
        });

    }

//    private void shippingList() {
//        ShippingModel shippingModel = new ShippingModel("Hidden Brains infotech pvt ltd","Nirav",
//                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380008",
//                "India","9090946464","hiddenbrains@hotmail.com");
//        shippingModels.add(shippingModel);
//        shippingModel = new ShippingModel("Seven Seas infotech pvt. ltd.","Krupal",
//                "Mehta","Jodhpur Char rasta","Ahmedabad","Gujarat","380010",
//                "India","9090946464","hiddenbrains@hotmail.com");
//        shippingModels.add(shippingModel);
//        shippingModel = new ShippingModel("Kaizen infocomm pvt. ltd.","Mukul",
//                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380020",
//                "India","9090946464","hiddenbrains@hotmail.com");
//        shippingModels.add(shippingModel);
//        shippingModel = new ShippingModel("Hidden Brains infotech pvt ltd","Nirav",
//                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380008",
//                "India","9090946464","hiddenbrains@hotmail.com");
//        shippingModels.add(shippingModel);
//        shippingModel = new ShippingModel("Seven seas infotech pvt. ltd.","Krupal",
//                "Mehta","Jodhpur Char rasta","Ahmedabad","Gujarat","380010",
//                "India","9090946464","hiddenbrains@hotmail.com");
//        shippingModels.add(shippingModel);
//        shippingModel = new ShippingModel("Kaizen infocomm pvt. ltd.","Mukul",
//                "Vasava","Jodhpur Char rasta","Ahmedabad","Gujarat","380020",
//                "India","9090946464","hiddenbrains@hotmail.com");
//        shippingModels.add(shippingModel);
//
//    }
//
public void AddShipping(){
    FindCustomerRequestEnvelope requestEnvelope = new FindCustomerRequestEnvelope();
    FindCustomerRequestBody requestBody = new FindCustomerRequestBody();
    FindCustomerRequestBody.RequestFindCustomer requestModel = new FindCustomerRequestBody.RequestFindCustomer();
    requestModel.searchtext = "L";
    requestModel.companyId = "10004";
    requestModel.xmlns = "http://tempuri.org/";
    requestBody.requestFindCustomer = requestModel;
    requestEnvelope.body = requestBody;
    Call<FindCustomerResponseEnvelope> call = RetrofitGenerator.getApiService().findCutomerX(requestEnvelope);
    call.enqueue(new Callback<FindCustomerResponseEnvelope>() {
        @Override
        public void onResponse(Call<FindCustomerResponseEnvelope> call, Response<FindCustomerResponseEnvelope> response) {
            swipeRefreshLayout.setRefreshing(false);
            Gson gson = new Gson();
            FindCustomerResponse findCustomerResponse = gson.fromJson(response.body().
                    body.findCustomerReponseModel.FindCustomerResult,FindCustomerResponse.class);
           if(findCustomerResponse.getSetting().getSuccess()){
               mAdapter.clear(false);
               mAdapter.addAll(findCustomerResponse.getData(), false);
               mAdapter.notifyDataSetChanged();

           }
        }

        @Override
        public void onFailure(Call<FindCustomerResponseEnvelope> call, Throwable t) {
            swipeRefreshLayout.setRefreshing(false);
        }
    });

}

}

