


package com.example.shopkeeper.findcustomer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.shopkeeper.R;

public class ShippingFragment extends Fragment {
    private ImageView closeFragment;
    private View shippingFragment;

    public ShippingFragment() {
        // Required empty public constructor
    }

    private FindCustomerModel findCustomerModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findCustomerModel = (FindCustomerModel) getArguments().getSerializable("model");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shipping, container, false);
        closeFragment = (ImageView) view.findViewById(R.id.imgclosefragment);
        shippingFragment = (View) view.findViewById(R.id.ShippingFragment);
        closeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shippingFragment.setVisibility(View.GONE);
            }
        });
        return view;
    }

    public void setData(Object s) {

    }
}