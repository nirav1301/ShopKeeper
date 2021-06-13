package com.example.shopkeeper;

import androidx.annotation.NonNull;

import com.example.shopkeeper.databinding.ItemOrderHistoryBinding;
import com.example.shopkeeper.orderhistory.OrderHistoryModel;

import easyadapter.dc.com.library.EasyAdapter;

public class XOrderHistoryAdapter extends EasyAdapter<OrderHistoryModel, ItemOrderHistoryBinding> {


    public XOrderHistoryAdapter() {
        super(R.layout.item_order_history);
    }

    @Override
    public void onCreatingHolder(@NonNull ItemOrderHistoryBinding binding, @NonNull EasyHolder holder) {
        super.onCreatingHolder(binding, holder);
        binding.getRoot().setOnClickListener(holder.getClickListener());
    }

    @Override
    public void onBind(@NonNull ItemOrderHistoryBinding itemOrderHistoryBinding, @NonNull OrderHistoryModel orderHistoryModel) {
        itemOrderHistoryBinding.txtordernum.setText(String.valueOf(orderHistoryModel.getInventoryOrderID()));
        itemOrderHistoryBinding.txtorderstatus.setText(orderHistoryModel.getOrderStatus());
        itemOrderHistoryBinding.txtcompanyname.setText(orderHistoryModel.getCompanyName());
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);*/
        itemOrderHistoryBinding.txtordertime.setText(orderHistoryModel.getDateTimeOrder());
        itemOrderHistoryBinding.orderinvoicenum.setText(orderHistoryModel.getInvoiceNo());
        itemOrderHistoryBinding.txtorderamount.setText(String.valueOf(orderHistoryModel.getTotalOrderAmount()));
    }
}
