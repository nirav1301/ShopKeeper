package com.example.shopkeeper.orderhistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.orderhistory.request.OrderHistoryRequestBody;
import com.example.shopkeeper.orderhistory.request.OrderHistoryRequestEnvelope;
import com.example.shopkeeper.orderhistory.response.OrderHistoryResponseEnvelope;
import com.google.gson.Gson;

import java.util.ArrayList;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryFragment extends Fragment {
    private String demo;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerview;
    private SearchView orderHistorySearch;
    private OrderHistoryAdapter mAdapter;

    public OrderHistoryFragment() {
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

    public void getOrderHistory() {
        OrderHistoryRequestEnvelope requestEnvelope = new OrderHistoryRequestEnvelope();
        OrderHistoryRequestBody requestBody = new OrderHistoryRequestBody();
        OrderHistoryRequestBody.RequestOrderHistory requestModel = new OrderHistoryRequestBody.RequestOrderHistory();
        requestModel.companyId = "10015";
        requestModel.pageNum = "1";
        requestModel.recordPerPage = "10";
        requestModel.orderId = "64188";
        requestModel.userId = "756";
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