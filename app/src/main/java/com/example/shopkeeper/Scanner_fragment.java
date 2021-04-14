package com.example.shopkeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.shopkeeper.Authentication.MainActivity;
import com.example.shopkeeper.Order.Shipping;

import java.util.Objects;


public class Scanner_fragment extends Fragment {
    private ImageButton imgBtnContinue;
    private ImageButton imgBtnScanner;

    public Scanner_fragment() {
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
        View v = inflater.inflate(R.layout.fragment_scanner_fragment, container, false);
        imgBtnContinue = (ImageButton) v.findViewById(R.id.imgbtnContinue);
        imgBtnScanner = (ImageButton) v.findViewById(R.id.imageButton2);
        imgBtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Shipping.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
        imgBtnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Scanner_Activity.class);
                startActivity(i);
            }
        });
        return v;
    }

}