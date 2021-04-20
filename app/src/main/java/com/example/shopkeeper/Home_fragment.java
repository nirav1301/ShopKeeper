package com.example.shopkeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.shopkeeper.Authentication.MainActivity;
import com.example.shopkeeper.HomeScreen.HomeScreenActivity;
import com.example.shopkeeper.HomeScreen.recadapter;
import com.example.shopkeeper.Remote.AndroidVersion;
import com.example.shopkeeper.Remote.ApiInterface;
import com.example.shopkeeper.Remote.JSONResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Home_fragment extends Fragment {
    private List<Movie> movieList = new ArrayList<>();
    private List<RecentOrder> recentOrders = new ArrayList<>();
    private RecyclerView recyclerView;
   // private MovieAdapter mAdapter;
    private RecentOrderAdapter mAdapter;
    private TextView viewOrders;
    private ImageButton imageButtonLogout;

    public Home_fragment() {
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
        viewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        imageButtonLogout = (ImageButton) view.findViewById(R.id.imageButton);
        imageButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
                Objects.requireNonNull(getActivity()).onBackPressed();

            }

        });

        mAdapter = new RecentOrderAdapter(recentOrders);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        AddRecentOrder();

       // prepareMovieData();
        return view;

    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();

    }
    private void AddRecentOrder(){
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