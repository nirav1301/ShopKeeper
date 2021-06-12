package com.example.shopkeeper.sendinvoice;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.shopkeeper.R;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.databinding.ItemOrderDetailBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XSendInvoiceAdapter extends EasyAdapter<CreateOrderModel, ItemOrderDetailBinding> {
    public XSendInvoiceAdapter() {
        super(R.layout.item_order_detail);
    }
    @Override
    public void onBind(@NonNull ItemOrderDetailBinding itemOrderDetailBinding, @NonNull CreateOrderModel createOrderModel) {
        itemOrderDetailBinding.productUnitPrice.setText(String.valueOf(createOrderModel.getUnitPrice()));
        itemOrderDetailBinding.productStyleNumber.setText(String.valueOf(createOrderModel.getStyleNo()));
        itemOrderDetailBinding.productCategoryName.setText(String.valueOf(createOrderModel.getCat1Name()));
        itemOrderDetailBinding.productSizeRatio.setText(String.valueOf(createOrderModel.getSizeRatio()));
        if (createOrderModel.getProductColorImageAPIs() != null && createOrderModel.getProductColorImageAPIs().size() > 0) {
            Glide.with(itemOrderDetailBinding.imgViewProductImg)
                    .load(createOrderModel.getProductColorImageAPIs().get(0).getColorMediumImageUrl())
                    .placeholder(R.drawable.ic_search)
                    .error(R.drawable.ic_search)
                    .into(itemOrderDetailBinding.imgViewProductImg);
        } else {
            Glide.with(itemOrderDetailBinding.imgViewProductImg).load("")
                    .placeholder(R.drawable.ic_search)
                    .error(R.drawable.ic_search)
                    .into(itemOrderDetailBinding.imgViewProductImg);
        }
//        addProductBinding.productExpectedDate.setText(String.valueOf(createOrderModel.getExpectedDate()));
        itemOrderDetailBinding.productColor.setText(String.valueOf(createOrderModel.getColor()));


    }
}
