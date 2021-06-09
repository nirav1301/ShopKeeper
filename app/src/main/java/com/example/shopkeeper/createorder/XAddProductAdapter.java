package com.example.shopkeeper.createorder;

import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.shopkeeper.R;
import com.example.shopkeeper.databinding.AddProductBinding;

import easyadapter.dc.com.library.EasyAdapter;

public class XAddProductAdapter extends EasyAdapter<CreateOrderModel, AddProductBinding> {
    public XAddProductAdapter() {
        super(R.layout.add_product);
    }

    @Override
    public void onCreatingHolder(@NonNull AddProductBinding binding, @NonNull EasyHolder holder) {
        super.onCreatingHolder(binding, holder);
        binding.imgbtndelete.setOnClickListener(holder.getClickListener());
        /*binding.imgBtnPluQuantity.setOnClickListener(holder.getClickListener());*/
    }

    @Override
    public void onBind(@NonNull AddProductBinding addProductBinding, @NonNull CreateOrderModel createOrderModel) {
        addProductBinding.productUnitPrice.setText(String.valueOf(createOrderModel.getUnitPrice()));
        addProductBinding.productStyleNumber.setText(String.valueOf(createOrderModel.getStyleNo()));
        addProductBinding.productCategoryName.setText(String.valueOf(createOrderModel.getCat1Name()));
        addProductBinding.productSizeRatio.setText(String.valueOf(createOrderModel.getSizeRatio()));

        if (createOrderModel.getProductColorImageAPIs() != null && createOrderModel.getProductColorImageAPIs().size() > 0) {
            Glide.with(addProductBinding.imgViewProductImg)
                    .load(createOrderModel.getProductColorImageAPIs().get(0).getColorMediumImageUrl())
                    .placeholder(R.drawable.ic_search)
                    .error(R.drawable.ic_search)
                    .into(addProductBinding.imgViewProductImg);
        } else {
            Glide.with(addProductBinding.imgViewProductImg).load("")
                    .placeholder(R.drawable.ic_search)
                    .error(R.drawable.ic_search)
                    .into(addProductBinding.imgViewProductImg);
        }
//        addProductBinding.productExpectedDate.setText(String.valueOf(createOrderModel.getExpectedDate()));
        addProductBinding.productColor.setText(String.valueOf(createOrderModel.getColor()));
        String qualityString = addProductBinding.productQuantity.getText().toString();
        if (!TextUtils.isEmpty(qualityString)) {
            int quantity = Integer.parseInt(qualityString);
            int totalPrice = quantity * createOrderModel.getUnitPrice();
            addProductBinding.productTotalPrice.setText(String.valueOf(totalPrice));
        } else {
            int quantity = 5;
            int totalPrice = quantity * createOrderModel.getUnitPrice();
            addProductBinding.productTotalPrice.setText(String.valueOf(totalPrice));
        }
        addProductBinding.imgBtnMinusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = addProductBinding.productQuantity.getText().toString();
                int minusQuantity = Integer.parseInt(quantity);
                minusQuantity = minusQuantity - 1;
                addProductBinding.productQuantity.setText(String.valueOf(minusQuantity));
                int totalPrice = minusQuantity * createOrderModel.getUnitPrice();
                addProductBinding.productTotalPrice.setText(String.valueOf(totalPrice));
            }
        });
        addProductBinding.imgBtnPluQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = addProductBinding.productQuantity.getText().toString();
                int plusQuantity = Integer.parseInt(quantity);
                plusQuantity = plusQuantity + 1;
                addProductBinding.productQuantity.setText(String.valueOf(plusQuantity));
                int totalPrice = plusQuantity * createOrderModel.getUnitPrice();
                addProductBinding.productTotalPrice.setText(String.valueOf(totalPrice));
            }
        });


        /*addProductBinding.imgbtndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               removeOnly(getData().indexOf(createOrderModel));
               notifyDataSetChanged();

            }
        });*/


    }

}
