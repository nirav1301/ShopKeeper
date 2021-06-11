


package com.example.shopkeeper.findcustomer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shopkeeper.R;

public class ShippingFragment extends Fragment {
    private ImageView closeFragment;
    private View shippingFragment;
    private TextView companyName;
    private TextView companyStreet;
    private TextView companyCity;
    private TextView companyState;
    private TextView companyCountry;
    private TextView companyZipcode;
    private TextView companyPhone;

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
        companyName = view.findViewById(R.id.txtshippingcompanyname);
        companyStreet = view.findViewById(R.id.txtshippingstreetname);
        companyCity = view.findViewById(R.id.txtshippingcityname);
        companyState = view.findViewById(R.id.txtshippingstatename);
        companyCountry = view.findViewById(R.id.txtshippingcountryname);
        companyZipcode = view.findViewById(R.id.txtshippingzipcode);
        companyPhone = view.findViewById(R.id.txtshippingphone);
        setData(shippingFragment);


        closeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShippingFragment fragment = new ShippingFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return view;
    }

    public void setData(Object s) {
        companyName.setText(findCustomerModel.getCustomerCompanyName());
        companyStreet.setText(findCustomerModel.getShippingStreet());
        companyCity.setText(findCustomerModel.getShippingCity());
        companyState.setText(findCustomerModel.getShippingStateOrProvince());
        companyCountry.setText(findCustomerModel.getShippingCountry());
        companyZipcode.setText(findCustomerModel.getShippingZipcode());
        companyPhone.setText(findCustomerModel.getMailingPhone());


    }
}