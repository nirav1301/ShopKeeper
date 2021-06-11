package com.example.shopkeeper.sendorder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.findcustomer.FindCustomerModel;
import com.example.shopkeeper.sendinvoice.SendInvoiceActivity;
import com.example.shopkeeper.sendorder.request.SendOrderRequestBody;
import com.example.shopkeeper.sendorder.request.SendOrderRequestEnvelope;
import com.example.shopkeeper.sendorder.response.SendOrderResponseEnvelope;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceOrderActivity extends AppCompatActivity {
    private Button btnPlaceOrder;
    private FindCustomerModel findCustomerModel;
    private TextView pocompanyname;
    private TextView pocompanystreet;
    private TextView pocompanycity;
    private TextView pocompanystate;
    private TextView pocompanyzipcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        btnPlaceOrder = findViewById(R.id.btnplaceorder);
        pocompanyname = findViewById(R.id.pocompanyname);
        pocompanystreet = findViewById(R.id.pocompanystreet);
        pocompanycity = findViewById(R.id.pocomapnycity);
        pocompanystate = findViewById(R.id.pocompanystate);
        pocompanyzipcode = findViewById(R.id.pocompanyzipcode);

        findCustomerModel = (FindCustomerModel) getIntent().getSerializableExtra("data");
        CreateOrderModel createOrderModel = (CreateOrderModel) getIntent().getSerializableExtra("abcd");
//        pocompanyname.setText(findCustomerModel.getCustomerCompanyName());
//        pocompanystreet.setText(findCustomerModel.getShippingStreet());
//        pocompanycity.setText(findCustomerModel.getShippingCity());
//        pocompanystate.setText(findCustomerModel.getShippingStateOrProvince());
//        pocompanyzipcode.setText(findCustomerModel.getShippingZipcode());

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
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
        requestModel.OrderNote = "";
        requestModel.ProductStyle = "";
        requestModel.CompanyWebsite = "";
        requestModel.ProductInfo = "";
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