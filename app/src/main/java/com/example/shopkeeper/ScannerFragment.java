package com.example.shopkeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dc.codescanner.CodeScannerActivity;
import com.dc.codescanner.CodeScannerConfig;
import com.dc.codescanner.controls.ScannerResult;
import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.createorder.CreateOrderResponse;
import com.example.shopkeeper.createorder.Request.CreateOrderRequestBody;
import com.example.shopkeeper.createorder.Request.CreateOrderRequestEnvelope;
import com.example.shopkeeper.createorder.Response.CreateOrderResponseEnvelope;
import com.example.shopkeeper.createorder.XAddProductAdapter;
import com.example.shopkeeper.databinding.FragmentScannerFragmentBinding;
import com.example.shopkeeper.findcustomer.ShippingActivity;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import easyadapter.dc.com.library.EasyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScannerFragment extends Fragment {
    private FragmentScannerFragmentBinding binding;
    private String myResult;
    private String pCode;
    private String cCode;
    private XAddProductAdapter mAdapter;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new XAddProductAdapter();
        mAdapter.setRecyclerViewItemClick(new EasyAdapter.OnRecyclerViewItemClick<CreateOrderModel>() {
            @Override
            public void onRecyclerViewItemClick(View view, CreateOrderModel model) {
                switch (view.getId()) {
                    case R.id.imgbtndelete:
                        mAdapter.remove(model);
                        binding.coproductstyle.setText(String.valueOf(mAdapter.getItemCount()));
                        break;
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScannerFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.coproductstyle.setText(String.valueOf(mAdapter.getItemCount()));
        binding.imgbtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mAdapter.getItemCount() <= 0){
//                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
//                    builder1.setTitle("Warning");
//                    builder1.setMessage("Please add any item");
//                    builder1.setCancelable(true);
//                    builder1.setNeutralButton(android.R.string.ok,
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//
//                    AlertDialog alert11 = builder1.create();
//                    alert11.show();
//                }

                    Intent i = new Intent(getActivity(), ShippingActivity.class);
                    i.putExtra("items", mAdapter.getData());
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
                Home_fragment fragment = new Home_fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        binding.recviewAddProduct.setLayoutManager(mLayoutManager);
        binding.recviewAddProduct.setItemAnimator(new DefaultItemAnimator());
        binding.recviewAddProduct.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 789) {
            if (resultCode == Activity.RESULT_OK) {
                ScannerResult scannerResult = data.getParcelableExtra((CodeScannerActivity.Companion.getRESULT_KEY()));
                Toast.makeText(getActivity(),scannerResult.getResult(), Toast.LENGTH_SHORT).show();
                myResult = scannerResult.getResult();
                pCode = myResult.substring(0, 6);
                cCode = myResult.substring(7);
                addProductToList();
            }
        }
    }

    private void addProductToList() {
        CreateOrderRequestEnvelope requestEnvelope = new CreateOrderRequestEnvelope();
        CreateOrderRequestBody requestBody = new CreateOrderRequestBody();
        CreateOrderRequestBody.RequestCreateOrder requestModel = new CreateOrderRequestBody.RequestCreateOrder();
        requestModel.companyId = "10015";
        requestModel.productId = pCode;
        requestModel.colorId = cCode;
        requestModel.userId = "756";
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
                        createOrderResponseModel.GetProductDetailByProductCodeResult, CreateOrderResponse.class);
                if (createOrderResponse.getSetting().getSuccess() == true) {
                    /*mAdapter.clear(false);*/
                    mAdapter.addAll(createOrderResponse.getData(), false);
                    binding.coproductstyle.setText(String.valueOf(mAdapter.getItemCount()));
                    mAdapter.notifyDataSetChanged();


//                    Intent intent=new Intent(requireContext(), PlaceOrder.class);
//                    intent.putExtra("abcd",createOrderResponse.getData().get(0));
//                    startActivity(intent);


                }
            }

            @Override
            public void onFailure(Call<CreateOrderResponseEnvelope> call, Throwable t) {

            }
        });
    }

}