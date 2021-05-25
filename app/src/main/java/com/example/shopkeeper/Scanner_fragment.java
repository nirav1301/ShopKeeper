package com.example.shopkeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dc.codescanner.CodeScannerActivity;
import com.dc.codescanner.CodeScannerConfig;
import com.dc.codescanner.controls.ScannerResult;
import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderResponse;
import com.example.shopkeeper.createorder.Request.CreateOrderRequestBody;
import com.example.shopkeeper.createorder.Request.CreateOrderRequestEnvelope;
import com.example.shopkeeper.createorder.Response.CreateOrderResponseEnvelope;
import com.example.shopkeeper.createorder.XAddProductAdapter;
import com.example.shopkeeper.databinding.FragmentScannerFragmentBinding;
import com.example.shopkeeper.findcustomer.Shipping;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Scanner_fragment extends Fragment {
    private FragmentScannerFragmentBinding binding;
    private String myResult;
    private String pCode;
    private String cCode;
    private XAddProductAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScannerFragmentBinding.inflate(inflater, container, false);
        binding.imgbtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Shipping.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CodeScannerConfig codeScannerConfig = new CodeScannerConfig.Builder()
                        .setCodeType(CodeScannerConfig.CodeType.ALL_QR)
                        .build();
                Intent intentX = CodeScannerActivity.Companion.createIntent(requireContext(), codeScannerConfig);
                startActivityForResult(intentX, 789);
            }
        });
        binding.imgbtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


//        Glide.with(this).load("https://images.unsplash.com/photo-1617468505637-1230fb86d2cf?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80")
//                .placeholder(R.drawable.ic_continue)
//                .error(R.drawable.ic_continue)
//                .into(binding.imageProfile);


        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 789) {
            if (resultCode == Activity.RESULT_OK) {
                ScannerResult scannerResult = data.getParcelableExtra((CodeScannerActivity.Companion.getRESULT_KEY()));
                myResult = scannerResult.getResult();
                pCode = myResult.substring(0,6);
                cCode = myResult.substring(7);
                addProductToList();

            }
        }
    }

    private void addProductToList() {
        CreateOrderRequestEnvelope requestEnvelope = new  CreateOrderRequestEnvelope();
        CreateOrderRequestBody requestBody = new CreateOrderRequestBody();
        CreateOrderRequestBody.RequestCreateOrder requestModel = new CreateOrderRequestBody.RequestCreateOrder();
        requestModel.companyId = "10004";
        requestModel.productId = pCode;
        requestModel.colorId = cCode;
        requestModel.userId ="740";
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestCreateOrder = requestModel;
        requestEnvelope.body = requestBody;
        Call<CreateOrderResponseEnvelope> call =
                RetrofitGenerator.getApiService().createOrderX(requestEnvelope);
        call.enqueue(new Callback<CreateOrderResponseEnvelope>() {
            @Override
            public void onResponse(Call<CreateOrderResponseEnvelope> call, Response<CreateOrderResponseEnvelope> response) {
                Gson gson = new Gson();
                CreateOrderResponse createOrderResponse = gson.fromJson(response.body().body.
                        createOrderResponseModel.GetProductDetailByProductCodeResult,CreateOrderResponse.class);
                if(createOrderResponse.getSetting().getSuccess()==true){
                    mAdapter = new XAddProductAdapter();
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                    binding.recviewAddProduct.setLayoutManager(mLayoutManager);
                    binding.recviewAddProduct.setItemAnimator(new DefaultItemAnimator());
                    binding.recviewAddProduct.setAdapter(mAdapter);

                    mAdapter.clear(false);
                    mAdapter.addAll(createOrderResponse.getData(), false);
                    mAdapter.notifyDataSetChanged();
                }



            }

            @Override
            public void onFailure(Call<CreateOrderResponseEnvelope> call, Throwable t) {

            }
        });


    }
}