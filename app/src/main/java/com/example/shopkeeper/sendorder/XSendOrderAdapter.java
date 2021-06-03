package com.example.shopkeeper.sendorder;

import androidx.annotation.NonNull;

import com.example.shopkeeper.R;
import com.example.shopkeeper.databinding.AddProductBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XSendOrderAdapter extends EasyAdapter<SendOrderModel, AddProductBinding> {
    public XSendOrderAdapter() {
        super(R.layout.add_product);
    }

    @Override
    public void onBind(@NonNull AddProductBinding addProductBinding, @NonNull SendOrderModel sendOrderModel) {

    }
}
