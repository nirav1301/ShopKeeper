package com.example.shopkeeper.sendinvoice;

import androidx.annotation.NonNull;

import com.example.shopkeeper.R;
import com.example.shopkeeper.databinding.AddProductBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XSendInvoiceAdapter extends EasyAdapter<SendInvoiceModel, AddProductBinding> {
    public XSendInvoiceAdapter() {
        super(R.layout.add_product);
    }

    @Override
    public void onBind(@NonNull AddProductBinding addProductBinding, @NonNull SendInvoiceModel sendInvoiceModel) {

    }
}
