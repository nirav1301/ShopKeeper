package com.example.shopkeeper.findcustomer;

import androidx.annotation.NonNull;

import com.example.shopkeeper.R;
import com.example.shopkeeper.databinding.ShippingListBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XShippingAdapter extends EasyAdapter<FindCustomerModel, ShippingListBinding> {

    public XShippingAdapter() {
        super(R.layout.shipping_list);
    }

    @Override
    public void onCreatingHolder(@NonNull ShippingListBinding binding, @NonNull EasyHolder holder) {
        super.onCreatingHolder(binding, holder);
        binding.getRoot().setOnClickListener(holder.getClickListener());
    }

    @Override
    public void onBind(@NonNull ShippingListBinding shippingListBinding, @NonNull FindCustomerModel findCustomerModel) {
        shippingListBinding.txtcname.setText(findCustomerModel.getCustomerCompanyName());
        shippingListBinding.txtccity.setText(findCustomerModel.getShippingCity());
        shippingListBinding.txtcstate.setText(findCustomerModel.getShippingStateOrProvince());
        shippingListBinding.txtczipcode.setText(findCustomerModel.getShippingZipcode());
    }
}
