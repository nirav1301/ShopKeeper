package com.example.shopkeeper.sendinvoice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.login.RetrofitGenerator;
import com.example.shopkeeper.createorder.CreateOrderModel;
import com.example.shopkeeper.homescreen.HomeActivity;
import com.example.shopkeeper.orderhistory.OrderHistoryModel;
import com.example.shopkeeper.sendinvoice.request.SendInvoiceRequestBody;
import com.example.shopkeeper.sendinvoice.request.SendInvoiceRequestEnvelope;
import com.example.shopkeeper.sendinvoice.response.SendInvoiceResponseEnvelope;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendInvoiceActivity extends AppCompatActivity {

    private Button btnsendInvoice;
    private TextView odorderid;
    private TextView odordertime;
    private TextView odorderstatus;
    private TextView odcompanyname;
    private TextView odcompanystreet;
    private TextView odcompanycity;
    private TextView odcompanystate;
    private TextView odcompanyzicode;
    private TextView odorderstyle;
    private TextView odordertotal;
    private EditText etorderemail;
    private EditText etordercomment;
    private RecyclerView rvorderdetail;
    private XSendInvoiceAdapter mAdapter;
    private ArrayList<CreateOrderModel> items;
    private OrderHistoryModel selectOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_);
        
        selectOrder = (OrderHistoryModel) getIntent().getSerializableExtra("model");
        btnsendInvoice = findViewById(R.id.btnsendinvoice);
        odorderid = findViewById(R.id.odorderid);
        odordertime = findViewById(R.id.odordertime);
        odorderstatus = findViewById(R.id.odorderstatus);
        odcompanyname = findViewById(R.id.odcompanyname);
        odcompanystreet = findViewById(R.id.odcompanystreet);
        odcompanycity = findViewById(R.id.odcompanycity);
        odcompanystate = findViewById(R.id.odcompanystate);
        odcompanyzicode = findViewById(R.id.odcompanyzipcode);
        odorderstyle = findViewById(R.id.odorderstyle);
        odordertotal = findViewById(R.id.odordertotal);
        etorderemail = findViewById(R.id.etodemail);
        etordercomment = findViewById(R.id.odordercomment);
        rvorderdetail = findViewById(R.id.rvorderdetail);
//        odorderid.setText(selectOrder.getInventoryOrderID());
//        odordertime.setText(selectOrder.getOrderDateTime());
//        odorderstatus.setText(selectOrder.getOrderStatus());
//        odcompanyname.setText(customerModel.getCustomerCompanyName());
//        odcompanystreet.setText(customerModel.getShippingStreet());
//        odcompanycity.setText(customerModel.getShippingCity());
//        odcompanystate.setText(customerModel.getShippingStateOrProvince());
//        odcompanyzicode.setText(customerModel.getShippingZipcode());
//        odorderstyle.setText(String.valueOf(mAdapter.getItemCount()));
//        odordertotal.setText(String.valueOf(selectOrder.getTotalOrderAmount()));
//        etorderemail.setText(customerModel.getLoginID());

//        items = (ArrayList<CreateOrderModel>) getIntent().getSerializableExtra("items");
//        customerModel = (FindCustomerModel) getIntent().getSerializableExtra("customer");
//        selectOrder = (OrderHistoryModel) getIntent().getSerializableExtra("selectorder");
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        rvorderdetail.setLayoutManager(mLayoutManager);
//        rvorderdetail.setItemAnimator(new DefaultItemAnimator());
//        rvorderdetail.setAdapter(mAdapter);
//        loadProductDetail();

        btnsendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInvoice();
                /*Intent i = new Intent(SendInvoiceActivity.this,HomeActivity.class);
                startActivity(i);
                finish();*/
            }
        });

        odordertotal.setText(String.valueOf(selectOrder.getTotalOrderAmount()));
        odorderid.setText(String.valueOf(selectOrder.getInventoryOrderID()));
        odordertime.setText(String.valueOf(selectOrder.getDateTimeOrder()));
        odorderstatus.setText(String.valueOf(selectOrder.getOrderStatus()));

        odcompanyname.setText(selectOrder.getCompanyName());
    }

    private void loadProductDetail() {
        mAdapter.clear(false);
        mAdapter.addAll(items, false);
        mAdapter.notifyDataSetChanged();
    }

    public void sendInvoice() {
        SendInvoiceRequestEnvelope requestEnvelope = new SendInvoiceRequestEnvelope();
        SendInvoiceRequestBody requestBody = new SendInvoiceRequestBody();
        SendInvoiceRequestBody.RequestSendInvoice requestModel = new SendInvoiceRequestBody.RequestSendInvoice();
        requestModel.adminId = "756";
        requestModel.companyId = "10015";
        requestModel.inventoryOrderId = String.valueOf(selectOrder.getInventoryOrderID());
        requestModel.productStyle = "2";
        requestModel.email = etorderemail.getText().toString();
        requestModel.comment = etordercomment.getText().toString();
        requestModel.companyWebsite = "";
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestSendInvoice = requestModel;
        requestEnvelope.body = requestBody;
        Call<SendInvoiceResponseEnvelope> call = RetrofitGenerator.getApiService().sendinvoiceX(requestEnvelope);
        call.enqueue(new Callback<SendInvoiceResponseEnvelope>() {
            @Override
            public void onResponse(Call<SendInvoiceResponseEnvelope> call, Response<SendInvoiceResponseEnvelope> response) {
                Gson gson = new Gson();
                SendInvoiceResponse sendInvoiceResponse = gson.fromJson(response.body().body.
                        sendInvoiceResponseModel.EmailPlaceOrderResult, SendInvoiceResponse.class);
                if (sendInvoiceResponse.getSettings().isSuccess() == true) {
                    Intent i = new Intent(SendInvoiceActivity.this, HomeActivity.class);
                    Toast.makeText(SendInvoiceActivity.this, "Invoice Sent", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(SendInvoiceActivity.this, "Falied to sent Invoice", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SendInvoiceResponseEnvelope> call, Throwable t) {

            }
        });

    }
}