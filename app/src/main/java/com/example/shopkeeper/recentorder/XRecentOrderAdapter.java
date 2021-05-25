package com.example.shopkeeper.recentorder;

import androidx.annotation.NonNull;

import com.example.shopkeeper.R;
import com.example.shopkeeper.databinding.RecentOrderBinding;
import com.example.shopkeeper.recentorder.response.RecentOrderModel;

import easyadapter.dc.com.library.EasyAdapter;


public class XRecentOrderAdapter extends EasyAdapter<RecentOrderModel, RecentOrderBinding> {
    public XRecentOrderAdapter() {
        super(R.layout.recent_order);


    }

    @Override
    public void onCreatingHolder(@NonNull RecentOrderBinding binding, @NonNull EasyHolder holder) {
        super.onCreatingHolder(binding, holder);
        binding.getRoot().setOnClickListener(holder.getClickListener());
    }

    @Override
    public void onBind(@NonNull RecentOrderBinding recentOrderBinding, @NonNull RecentOrderModel recentOrder) {
        recentOrderBinding.txtordernum.setText(String.valueOf(recentOrder.getInventoryOrderID()));
        recentOrderBinding.txtorderstatus.setText(recentOrder.getOrderStatus());
        recentOrderBinding.txtcompanyname.setText(recentOrder.getCompanyName());
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);*/
        recentOrderBinding.txtordertime.setText(recentOrder.getDateTimeOrder());
        recentOrderBinding.orderinvoicenum.setText(recentOrder.getInvoiceNo());
        recentOrderBinding.txtorderamount.setText(String.valueOf(recentOrder.getTotalOrderAmount()));

    }
}
