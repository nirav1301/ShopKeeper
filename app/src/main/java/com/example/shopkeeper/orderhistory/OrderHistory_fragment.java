package com.example.shopkeeper.orderhistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.R;
import com.example.shopkeeper.orderhistory.Request.OrderHistoryRequestBody;
import com.example.shopkeeper.orderhistory.Request.OrderHistoryRequestEnvelope;
import com.example.shopkeeper.orderhistory.Response.OrderHistoryResponseEnvelope;
import com.google.gson.Gson;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistory_fragment extends Fragment  {
    private String demo;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerview;
    private SearchView orderHistorySearch;
    private OrderHistoryAdapter mAdapter;

    public OrderHistory_fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_history_fragment, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.orderhisrecview);
        orderHistorySearch = view.findViewById(R.id.searchorderhistory);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipereforderhistory);
        mAdapter = new OrderHistoryAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        demo = orderHistorySearch.getQuery().toString();
        recyclerview.setAdapter(mAdapter);
        getOrderHistory();
        mAdapter.setRecyclerViewItemClick(new EasyAdapter.OnRecyclerViewItemClick<OrderHistoryModel>() {
            @Override
            public void onRecyclerViewItemClick(View view, OrderHistoryModel model) {
                Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
              getOrderHistory();
            }
        });

        // prepareMovieData();
        return view;


    }
    public void getOrderHistory(){
        OrderHistoryRequestEnvelope requestEnvelope = new  OrderHistoryRequestEnvelope();
        OrderHistoryRequestBody requestBody = new OrderHistoryRequestBody();
        OrderHistoryRequestBody.RequestOrderHistory requestModel = new OrderHistoryRequestBody.RequestOrderHistory();
        requestModel.companyId = "10004";
        requestModel.pageNum = "1";
        requestModel.recordPerPage = "10";
        requestModel.orderId = "64188";
        requestModel.userId = "740";
        requestModel.searchtext = demo;
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
                        orderHistoryResponseModel.GetOrderHistryResult,OrderHistoryResponse.class);
                if(orderHistoryResponse.getSetting().getSuccess()){
                    mAdapter.clear(false);
                    mAdapter.addAll(orderHistoryResponse.getData(), false);
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