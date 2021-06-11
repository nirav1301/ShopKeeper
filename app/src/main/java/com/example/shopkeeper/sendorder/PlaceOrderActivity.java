package com.example.shopkeeper.sendorder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.databinding.ActivityPlaceOrderBinding;
import com.example.shopkeeper.findcustomer.FindCustomerModel;
import com.example.shopkeeper.sendinvoice.SendInvoiceActivity;
import com.example.shopkeeper.sendorder.request.SendOrderRequestBody;
import com.example.shopkeeper.sendorder.request.SendOrderRequestEnvelope;
import com.example.shopkeeper.sendorder.response.SendOrderResponseEnvelope;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceOrderActivity extends AppCompatActivity {
    private FindCustomerModel findCustomerModel;
    private ArrayList<CreateOrderModel> items;
    private FindCustomerModel customerModel;
    private ActivityPlaceOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_place_order);

        items = (ArrayList<CreateOrderModel>) getIntent().getSerializableExtra("items");
        customerModel = (FindCustomerModel) getIntent().getSerializableExtra("customer");

        binding.pocompanyname.setText(findCustomerModel.getCustomerCompanyName());
        binding.pocompanystreet.setText(findCustomerModel.getShippingStreet());
        binding.pocomapnycity.setText(findCustomerModel.getShippingCity());
        binding.pocompanystate.setText(findCustomerModel.getShippingStateOrProvince());
        binding.pocompanyzipcode.setText(findCustomerModel.getShippingZipcode());

        binding.btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sendOrder();
                AlertDialog alertDialog = new AlertDialog.Builder(PlaceOrderActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Good Job");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(PlaceOrderActivity.this, SendInvoiceActivity.class);
                                startActivity(i);
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }

    public void sendOrder() {
        SendOrderRequestEnvelope requestEnvelope = new SendOrderRequestEnvelope();
        SendOrderRequestBody requestBody = new SendOrderRequestBody();
        SendOrderRequestBody.RequestSendOrder requestModel = new SendOrderRequestBody.RequestSendOrder();
        requestModel.AdminId = "756";
        requestModel.CompanyId = "";
        requestModel.CustomerId = "";
        requestModel.OrderNote = binding.etordernote.getText().toString();
        requestModel.ProductStyle = "";
        requestModel.CompanyWebsite = "";




        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestSendOrder = requestModel;
        requestEnvelope.body = requestBody;
        Call<SendOrderResponseEnvelope> call = RetrofitGenerator.getApiService().sendorderX(requestEnvelope);
        call.enqueue(new Callback<SendOrderResponseEnvelope>() {
            @Override
            public void onResponse(Call<SendOrderResponseEnvelope> call, Response<SendOrderResponseEnvelope> response) {


            }

            @Override
            public void onFailure(Call<SendOrderResponseEnvelope> call, Throwable t) {

            }
        });
    }
}