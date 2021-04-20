package com.example.shopkeeper.Order;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopkeeper.Home;
import com.example.shopkeeper.R;

public class PlaceOrder extends AppCompatActivity {
    private Button btnPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        btnPlaceOrder = findViewById(R.id.btnplaceorder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(PlaceOrder.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Good Job");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(PlaceOrder.this, Order_Details_Activity.class);
                                startActivity(i);
                                dialog.dismiss();
                            }
                        });



                alertDialog.show();
            }
        });
    }
}