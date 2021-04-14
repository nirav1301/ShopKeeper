package com.example.shopkeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.dc.codescanner.CodeScannerActivity;
import com.dc.codescanner.CodeScannerConfig;
import com.dc.codescanner.controls.ScannerResult;
import com.example.shopkeeper.Order.Shipping;
import com.example.shopkeeper.databinding.FragmentScannerFragmentBinding;

import java.io.File;


public class Scanner_fragment extends Fragment {
    private FragmentScannerFragmentBinding binding;

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

        Glide.with(this).load("https://images.unsplash.com/photo-1617468505637-1230fb86d2cf?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80")
                .placeholder(R.drawable.ic_continue)
                .error(R.drawable.ic_continue)
                .into(binding.imageProfile);


        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 789) {
            if (resultCode == Activity.RESULT_OK) {
                ScannerResult scannerResult = data.getParcelableExtra((CodeScannerActivity.Companion.getRESULT_KEY()));
                /*Toast.makeText(requireContext(),scannerResult.getResult(),Toast.LENGTH_LONG).show();*/
                addProductToList(scannerResult.getResult());
            }
        }
    }

    private void addProductToList(String qrResult) {
        //Api Call
        //Product
        //Product add into recyclerview
    }
}