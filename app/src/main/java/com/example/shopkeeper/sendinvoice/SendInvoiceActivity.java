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

import com.example.shopkeeper.Home;
import com.example.shopkeeper.R;
import com.example.shopkeeper.authentication.Login.RetrofitGenerator;
import com.example.shopkeeper.sendinvoice.request.SendInvoiceRequestBody;
import com.example.shopkeeper.sendinvoice.request.SendInvoiceRequestEnvelope;
import com.example.shopkeeper.sendinvoice.response.SendInvoiceResponseEnvelope;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendInvoiceActivity extends AppCompatActivity {
    private Button btnsendInvoice;
    private TextView odorderid;
    private TextView odordertime;
    private TextView odorderstatus;
    private TextView odcompanyname;
    private TextView odcompanystreet ;
    private TextView odcompanycity;
    private TextView odcompanystate;
    private TextView odcompanyzicode;
    private TextView odorderstyle;
    private TextView odordertotal;
    private EditText etorderemail;
    private EditText etordercomment;
    private RecyclerView rvorderdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__details_);
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

        btnsendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // sendInvoice();
                Intent i = new Intent(SendInvoiceActivity.this, Home.class);
                startActivity(i);
                Toast.makeText(SendInvoiceActivity.this, "Invoice Sent", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    public void sendInvoice(){
        SendInvoiceRequestEnvelope requestEnvelope = new SendInvoiceRequestEnvelope();
        SendInvoiceRequestBody requestBody = new SendInvoiceRequestBody();
        SendInvoiceRequestBody.RequestSendInvoice requestModel = new SendInvoiceRequestBody.RequestSendInvoice();
        requestModel.adminId = "";
        requestModel.companyId= "";
        requestModel.inventoryOrderId ="";
        requestModel.productStyle="";
        requestModel.email = "";
        requestModel.comment ="";
        requestModel.companyWebsite ="";
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestSendInvoice= requestModel;
        requestEnvelope.body = requestBody;
        Call<SendInvoiceResponseEnvelope> call =  RetrofitGenerator.getApiService().sendinvoiceX(requestEnvelope);
        call.enqueue(new Callback<SendInvoiceResponseEnvelope>() {
            @Override
            public void onResponse(Call<SendInvoiceResponseEnvelope> call, Response<SendInvoiceResponseEnvelope> response) {

            }

            @Override
            public void onFailure(Call<SendInvoiceResponseEnvelope> call, Throwable t) {

            }
        });

    }
}