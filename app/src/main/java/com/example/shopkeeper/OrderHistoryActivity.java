package com.example.shopkeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.findcustomer.FindCustomerModel;
import com.example.shopkeeper.orderhistory.OrderHistoryModel;
import com.example.shopkeeper.orderhistory.OrderHistoryResponse;
import com.example.shopkeeper.orderhistory.request.OrderHistoryRequestBody;
import com.example.shopkeeper.orderhistory.request.OrderHistoryRequestEnvelope;
import com.example.shopkeeper.orderhistory.response.OrderHistoryResponseEnvelope;
import com.example.shopkeeper.sendinvoice.SendInvoiceActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerview;
    private SearchView orderHistorySearch;
    private ArrayList<CreateOrderModel> items;
    private FindCustomerModel customerModel;
    private OrderHistoryModel selectOrder;
    private XOrderHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        recyclerview = (RecyclerView) findViewById(R.id.orderhisrecview);
        orderHistorySearch = findViewById(R.id.searchorderhistory);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipereforderhistory);
        mAdapter = new XOrderHistoryAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        items = (ArrayList<CreateOrderModel>) getIntent().getSerializableExtra("items");
        customerModel = (FindCustomerModel) getIntent().getSerializableExtra("customer");
        orderHistorySearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchQuery(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchQuery(newText);
                return false;
            }
        });
        recyclerview.setAdapter(mAdapter);
        getOrderHistory();
        mAdapter.setRecyclerViewItemClick(new EasyAdapter.OnRecyclerViewItemClick<OrderHistoryModel>() {
            @Override
            public void onRecyclerViewItemClick(View view, OrderHistoryModel model) {
                Intent i = new Intent(OrderHistoryActivity.this, SendInvoiceActivity.class);
                i.putExtra("items",items);
                i.putExtra("customer",customerModel);
                i.putExtra("selectorder",model);
                startActivity(i);
                finish();


            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getOrderHistory();
            }
        });

        // prepareMovieData();


    }

    private void searchQuery(String keyword) {
        mAdapter.performFilter(keyword, new EasyAdapter.OnFilter<OrderHistoryModel>() {
            @Override
            public boolean onFilterApply(@Nullable Object keyword, @NonNull OrderHistoryModel model) {
                if (String.valueOf(model.getInventoryOrderID()).toLowerCase().contains(keyword.toString().toLowerCase())) {
                    return true;
                }

                if (String.valueOf(model.getCompanyName()).toLowerCase().contains(keyword.toString().toLowerCase())) {
                    return true;
                }

                return false;
            }

            @Override
            public void onFilterResult(ArrayList<OrderHistoryModel> filteredList)
            {
                mAdapter.clear(false);
                mAdapter.addAll(filteredList, false);
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    private void getOrderHistory() {
        OrderHistoryRequestEnvelope requestEnvelope = new OrderHistoryRequestEnvelope();
        OrderHistoryRequestBody requestBody = new OrderHistoryRequestBody();
        OrderHistoryRequestBody.RequestOrderHistory requestModel = new OrderHistoryRequestBody.RequestOrderHistory();
        requestModel.companyId = "10015";
        requestModel.pageNum = "1";
        requestModel.recordPerPage = "10";
        requestModel.orderId = "64188";
        requestModel.userId = "756";
        requestModel.searchtext = String.valueOf(orderHistorySearch.getQuery());
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestOrderHistory = requestModel;
        requestEnvelope.body = requestBody;
        Call<OrderHistoryResponseEnvelope> call =
                RetrofitGenerator.getApiService().orderHistoryX(requestEnvelope);
        call.enqueue(new Callback<OrderHistoryResponseEnvelope>() {
            @Override
            public void onResponse(Call<OrderHistoryResponseEnvelope> call, Response<OrderHistoryResponseEnvelope> response) {
                swipeRefreshLayout.setRefreshing(false);
                Gson gson = new Gson();
                OrderHistoryResponse orderHistoryResponse = gson.fromJson(response.body().body.
                        orderHistoryResponseModel.GetOrderHistryResult, OrderHistoryResponse.class);
                if (orderHistoryResponse.getSetting().getSuccess()) {
                    mAdapter.clear(true);
                    mAdapter.addAll(orderHistoryResponse.getData(), true);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<OrderHistoryResponseEnvelope> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

}