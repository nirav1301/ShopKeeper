package com.example.shopkeeper.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shopkeeper.R;

public class AddCustomer extends AppCompatActivity {
    private EditText etCustCompany;
    private EditText etCustFirstName;
    private EditText etCustLastName;
    private EditText etCustStreetadd;
    private EditText etCustCity;
    private EditText etCustState;
    private EditText etCustZipcode;
    private EditText etCustCountry;
    private EditText etCustPhone;
    private EditText etCustEmail;
    private Button btnAddCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        getSupportActionBar().hide();
        etCustCompany = findViewById(R.id.etcustcompanyname);
        etCustFirstName = findViewById(R.id.etcustfirstname);
        etCustLastName = findViewById(R.id.etcustlastname);
        etCustStreetadd = findViewById(R.id.etcuststreet);
        etCustCity = findViewById(R.id.etcustcity);
        etCustState = findViewById(R.id.etcuststate);
        etCustZipcode = findViewById(R.id.etcustzipcode);
        etCustCountry = findViewById(R.id.etcustcountry);
        etCustPhone = findViewById(R.id.etcustphone);
        etCustEmail = findViewById(R.id.etcustemail);
        btnAddCustomer = findViewById(R.id.btnaddcustdata);
        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CompanyName = etCustCompany.getText().toString().trim();
                String FirstName = etCustLastName.getText().toString().trim();
                String LastName = etCustLastName.getText().toString().trim();
                String Street = etCustStreetadd.getText().toString().trim();
                String City = etCustCity.getText().toString().trim();
                String State = etCustState.getText().toString().trim();
                String Zipcode = etCustZipcode.getText().toString().trim();
                String Country = etCustLastName.getText().toString().trim();
                String Phone = etCustPhone.getText().toString().trim();
                String Email = etCustEmail.getText().toString().trim();
                if(CompanyName.isEmpty()){
                    etCustCompany.requestFocus();
                    etCustCompany.setError("Company Name is Required");
                }
                else if(FirstName.isEmpty()){
                    etCustFirstName.requestFocus();
                    etCustFirstName.setError("First Name is Required");
                }
                else if(LastName.isEmpty()){
                    etCustLastName.requestFocus();
                    etCustLastName.setError("Last Name is Required");
                }
                else if(Street.isEmpty()){
                    etCustStreetadd.requestFocus();
                    etCustStreetadd.setError("Street is Required");
                }
                else if(City.isEmpty()){
                    etCustCity.requestFocus();
                    etCustCity.setError("City is required");
                }
                else if(State.isEmpty()){
                    etCustState.requestFocus();
                    etCustState.setError("State is Required");
                }
                else if(Zipcode.isEmpty()){
                    etCustZipcode.requestFocus();
                    etCustZipcode.setError("ZipCode is Required");
                }
                else if(Country.isEmpty()){
                    etCustCountry.requestFocus();
                    etCustCountry.setError("Country is required");
                }
                else if(Phone.isEmpty()){
                    etCustPhone.requestFocus();
                    etCustPhone.setError("Phone is required");
                }
                else if(! Patterns.PHONE.matcher(Phone).matches()){
                    etCustPhone.requestFocus();
                    etCustPhone.setError("Phone pattern is wrong");
                }
                else if(Email.isEmpty()){
                    etCustEmail.requestFocus();
                    etCustEmail.setError("Email is required");
                }
                else if(! Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    etCustEmail.requestFocus();
                    etCustEmail.setError("Email format is not correct");
                }
                else{
                    addCustomer();
                }
            }
        });
    }

    private void addCustomer() {

    }
}