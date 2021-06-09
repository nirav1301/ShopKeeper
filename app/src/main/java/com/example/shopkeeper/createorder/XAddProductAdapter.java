package com.example.shopkeeper.createorder;

import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.shopkeeper.R;
import com.example.shopkeeper.ScannerFragment;
import com.example.shopkeeper.databinding.AddProductBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XAddProductAdapter extends EasyAdapter<CreateOrderModel, AddProductBinding> {
    public XAddProductAdapter() {
        super(R.layout.add_product);
    }

    @Override
    public void onBind(@NonNull AddProductBinding addProductBinding, @NonNull CreateOrderModel createOrderModel) {
        addProductBinding.productUnitPrice.setText(String.valueOf(createOrderModel.getUnitPrice()));
        addProductBinding.productStyleNumber.setText(String.valueOf(createOrderModel.getStyleNo()));
        addProductBinding.productCategoryName.setText(String.valueOf(createOrderModel.getCat1Name()));
        addProductBinding.productSizeRatio.setText(String.valueOf(createOrderModel.getSizeRatio()));
        Glide.with().load(createOrderModel.getProductColorImageAPIs()).into(addProductBinding.imgViewProductImg);
//        addProductBinding.productExpectedDate.setText(String.valueOf(createOrderModel.getExpectedDate()));
        addProductBinding.productColor.setText(String.valueOf(createOrderModel.getColor()));
        String qualityString = addProductBinding.productQuantity.getText().toString();
        if (!TextUtils.isEmpty(qualityString)) {
            int quantity = Integer.parseInt(qualityString);
            int totalPrice = quantity * createOrderModel.getUnitPrice();
            addProductBinding.productTotalPrice.setText(String.valueOf(totalPrice));
        } else {
            int quantity =5;
            int totalPrice = quantity * createOrderModel.getUnitPrice();
            addProductBinding.productTotalPrice.setText(String.valueOf(totalPrice));
        }

    }

}
