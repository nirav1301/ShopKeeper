package com.example.shopkeeper.sendorder;

import androidx.annotation.NonNull;

import com.example.shopkeeper.R;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.databinding.ItemOrderDetailBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XSendOrderAdapter extends EasyAdapter<CreateOrderModel, ItemOrderDetailBinding> {

    public XSendOrderAdapter() {
        super(R.layout.item_order_detail);
    }

    @Override
    public void onBind(@NonNull ItemOrderDetailBinding itemOrderDetailBinding, @NonNull CreateOrderModel createOrderModel) {


    }
}
