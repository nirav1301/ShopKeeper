package com.example.shopkeeper.findcustomer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shopkeeper.addcustomer.AddCustomerActivity;
import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.findcustomer.request.FindCustomerRequestBody;
import com.example.shopkeeper.findcustomer.request.FindCustomerRequestEnvelope;
import com.example.shopkeeper.findcustomer.response.FindCustomerResponseEnvelope;
import com.example.shopkeeper.sendorder.PlaceOrderActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShippingActivity extends AppCompatActivity {
    //    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Button btngotoPlaceOrder;
    private Button addCustomer;
    private SearchView shippingSearch;
    private View shippingfragment;
    //    private List<ShippingModel> shippingModels = new ArrayList<>();
    private XShippingAdapter mAdapter;

    private FindCustomerModel selectCustomerModel;
    private ArrayList<CreateOrderModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        items= (ArrayList<CreateOrderModel>) getIntent().getSerializableExtra("items");


        addCustomer = findViewById(R.id.btnaddcustomer);
        btngotoPlaceOrder = findViewById(R.id.btngotoplaceorder);
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        shippingSearch = findViewById(R.id.shippingsearch);
        swipeRefreshLayout = findViewById(R.id.swipeforrefshipping);
        shippingfragment = findViewById(R.id.ShippingFragment);
        shippingfragment.setVisibility(View.GONE);
        mAdapter = new XShippingAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        shippingSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchQuery(query);
                AddShipping();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchQuery(newText);
                AddShipping();
                return false;
            }
        });
        AddShipping();
        mAdapter.setRecyclerViewItemClick(new EasyAdapter.OnRecyclerViewItemClick<FindCustomerModel>() {
            @Override
            public void onRecyclerViewItemClick(View view, FindCustomerModel model) {

                selectCustomerModel = model;
                shippingfragment.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);


                ShippingFragment shippingFragment = new ShippingFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("model", model);
                shippingFragment.setArguments(bundle);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ShippingFragment, shippingFragment)
                        .commit();

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
//                Intent intent = new Intent(ShippingActivity.this, PlaceOrderActivity.class);
//                startActivity(intent);
                if (selectCustomerModel != null) {
                    Intent i = new Intent(ShippingActivity.this, PlaceOrderActivity.class);
                    i.putExtra("items",items);
                    i.putExtra("customer", selectCustomerModel);
                    startActivity(i);
                } else {
                    Toast.makeText(ShippingActivity.this, "Please select customer", Toast.LENGTH_SHORT).show();
                }

            }
        });
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShippingActivity.this, AddCustomerActivity.class);
                startActivity(intent);
            }
        });

    }


    private void searchQuery(String keyword) {
        mAdapter.performFilter(keyword, new EasyAdapter.OnFilter<FindCustomerModel>() {
            @Override
            public boolean onFilterApply(@Nullable Object keyword, @NonNull FindCustomerModel model) {
                if (String.valueOf(model.getCustomerName()).toLowerCase().contains(keyword.toString().toLowerCase())) {
                    return true;
                }

                if (String.valueOf(model.getCustomerCompanyName()).toLowerCase().contains(keyword.toString().toLowerCase())) {
                    return true;
                }

                return false;
            }

            @Override
            public void onFilterResult(ArrayList<FindCustomerModel> filteredList) {
                mAdapter.clear(false);
                mAdapter.addAll(filteredList, false);
                mAdapter.notifyDataSetChanged();
            }
        });
    }


    public void AddShipping() {
        FindCustomerRequestEnvelope requestEnvelope = new FindCustomerRequestEnvelope();
        FindCustomerRequestBody requestBody = new FindCustomerRequestBody();
        FindCustomerRequestBody.RequestFindCustomer requestModel = new FindCustomerRequestBody.RequestFindCustomer();
        requestModel.searchtext = shippingSearch.getQuery().toString();
        requestModel.companyId = "10015";
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
                        body.findCustomerReponseModel.FindCustomerResult, FindCustomerResponse.class);
                if (findCustomerResponse.getSetting().getSuccess()) {
                    mAdapter.clear(true);
                    mAdapter.addAll(findCustomerResponse.getData(), true);
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

