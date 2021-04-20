package com.example.shopkeeper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderHistory_fragment extends Fragment  {
    private RecyclerView recyclerview;
    private SearchView orderHistorySearch;
    private List<RecentOrder> recentOrders = new ArrayList<>();
    private RecentOrderAdapter mAdapter;

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
        mAdapter = new RecentOrderAdapter(recentOrders);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter);
        AddRecentOrder();

        // prepareMovieData();
        return view;


    }

    private void AddRecentOrder() {
        RecentOrder recentOrder = new RecentOrder("ST39487","In Progress","HiddenBrains Info Tech Pvt Ltd.",
                "09 sep 2020 | 11:04 AM","1245,5321,1245","$1220");
        recentOrders.add(recentOrder);
        recentOrder = new RecentOrder("ST39488","In Progress","Kaizen Infocomm Pvt. Ltd.",
                "10 sep 2020 | 05:04 PM","1247,5325,1248","$1300");
        recentOrders.add(recentOrder);
        recentOrder = new RecentOrder("ST39489","In Progress","Seven seas infotech Pvt. Ltd",
                "11 sep 2020 | 08:10 PM","1248,5323,1246","$1450");
        recentOrders.add(recentOrder);
        recentOrder = new RecentOrder("ST39490","In Progress","Sophos Securities",
                "12 sep 2020 | 12:16 PM","1249,5329,1249","$1500");
        recentOrders.add(recentOrder);
        recentOrder = new RecentOrder("ST39488","In Progress","Kaizen Infocomm Pvt. Ltd.",
                "10 sep 2020 | 05:04 PM","1247,5325,1248","$1300");
        recentOrders.add(recentOrder);
        recentOrder = new RecentOrder("ST39489","In Progress","Seven seas infotech Pvt. Ltd",
                "11 sep 2020 | 08:10 PM","1248,5323,1246","$1450");
        recentOrders.add(recentOrder);
        recentOrder = new RecentOrder("ST39490","In Progress","Sophos Securities",
                "12 sep 2020 | 12:16 PM","1249,5329,1249","$1500");
        recentOrders.add(recentOrder);


    }


}