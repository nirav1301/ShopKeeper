package com.example.shopkeeper.orderhistory;

import androidx.annotation.NonNull;

import com.example.shopkeeper.R;
import com.example.shopkeeper.databinding.RecentOrderBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class OrderHistoryAdapter extends EasyAdapter<OrderHistoryModel, RecentOrderBinding> {
    public OrderHistoryAdapter() {
        super(R.layout.recent_order);

    }


    @Override
    public void onCreatingHolder(@NonNull RecentOrderBinding binding, @NonNull EasyHolder holder) {
        super.onCreatingHolder(binding, holder);
        binding.getRoot().setOnClickListener(holder.getClickListener());
    }

    @Override
    public void onBind(@NonNull RecentOrderBinding recentOrderBinding, @NonNull OrderHistoryModel orderHistoryModel) {
        recentOrderBinding.txtordernum.setText(String.valueOf(orderHistoryModel.getInventoryOrderID()));
        recentOrderBinding.txtorderstatus.setText(orderHistoryModel.getOrderStatus());
        recentOrderBinding.txtcompanyname.setText(orderHistoryModel.getCompanyName());
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);*/
        recentOrderBinding.txtordertime.setText(orderHistoryModel.getDateTimeOrder());
        recentOrderBinding.orderinvoicenum.setText(orderHistoryModel.getInvoiceNo());
        recentOrderBinding.txtorderamount.setText(String.valueOf(orderHistoryModel.getTotalOrderAmount()));
    }
}
