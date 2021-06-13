package com.example.shopkeeper.recentorder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.MainActivity;
import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.orderhistory.OrderHistoryFragment;
import com.example.shopkeeper.recentorder.request.RecentOrderRequestBody;
import com.example.shopkeeper.recentorder.request.RecentOrderRequestEnvelope;
import com.example.shopkeeper.recentorder.response.RecentOrderModel;
import com.example.shopkeeper.recentorder.response.RecentOrderResponse;
import com.example.shopkeeper.recentorder.response.RecentOrderResponseEnvelope;
import com.google.gson.Gson;

import java.util.Objects;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecentOrderFragment extends Fragment {
    private RecyclerView recyclerView;
    // private MovieAdapter mAdapter;
    private XRecentOrderAdapter mAdapter;
    private TextView viewOrders;
    private ImageButton imageButtonLogout;
    private SwipeRefreshLayout swipeRefreshLayout;

    public RecentOrderFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment;
        Fragment me = this;
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.orderrec);
        viewOrders = (TextView) view.findViewById(R.id.viewAllOrder);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefrecentorder);
//

        viewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderHistoryFragment fragment = new OrderHistoryFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        imageButtonLogout = (ImageButton) view.findViewById(R.id.imageButton);
        imageButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog();
            }

        });

        mAdapter = new XRecentOrderAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        getRecentOrderData();
        mAdapter.setRecyclerViewItemClick(new EasyAdapter.OnRecyclerViewItemClick<RecentOrderModel>() {
            @Override
            public void onRecyclerViewItemClick(View view, RecentOrderModel model) {

            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getRecentOrderData();
            }
        });


        // prepareMovieData();
        return view;

    }

    public void getRecentOrderData() {
        RecentOrderRequestEnvelope requestEnvelope = new RecentOrderRequestEnvelope();
        RecentOrderRequestBody requestBody = new RecentOrderRequestBody();
        RecentOrderRequestBody.RequestRecentOrders requestModel = new RecentOrderRequestBody.RequestRecentOrders();
        requestModel.companyId = "10015";
        requestModel.userId = "756";
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestRecentOrders = requestModel;
        requestEnvelope.body = requestBody;
        Call<RecentOrderResponseEnvelope> call =
                RetrofitGenerator.getApiService().recentOrderX(requestEnvelope);
        call.enqueue(new Callback<RecentOrderResponseEnvelope>() {
            @Override
            public void onResponse(Call<RecentOrderResponseEnvelope> call, Response<RecentOrderResponseEnvelope> response) {
                swipeRefreshLayout.setRefreshing(false);
                Gson gson = new Gson();
                RecentOrderResponse recentOrderResponse = gson.fromJson(response.body().body.
                        recentOrderResponseModel.GetRecentOrdersResult, RecentOrderResponse.class);
                if (recentOrderResponse.getSetting().getSuccess() == true) {
                    mAdapter.clear(false);
                    mAdapter.addAll(recentOrderResponse.getData(), false);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<RecentOrderResponseEnvelope> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage("Please Select any option");
        dialog.setTitle("Are you want to logout? ");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);
                        ((Activity) getActivity()).overridePendingTransition(0, 0);
                        Objects.requireNonNull(getActivity()).onBackPressed();
                    }
                });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }


}