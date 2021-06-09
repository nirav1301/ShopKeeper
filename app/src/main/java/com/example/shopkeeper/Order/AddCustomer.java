package com.example.shopkeeper.Order;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopkeeper.R;
import com.example.shopkeeper.addcustomer.request.AddCustomerRequestBody;
import com.example.shopkeeper.addcustomer.request.AddCustomerRequestEnvelope;
import com.example.shopkeeper.addcustomer.response.AddCustomerResponseEnvelope;
import com.example.shopkeeper.authentication.Login.RetrofitGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        AddCustomerRequestEnvelope requestEnvelope = new AddCustomerRequestEnvelope();
        AddCustomerRequestBody requestBody = new AddCustomerRequestBody();
        AddCustomerRequestBody.RequestAddCustomer requestModel = new AddCustomerRequestBody.RequestAddCustomer();
        requestModel.CompanyCustomerID = "";
        requestModel.CustomerCompanyName = "";
        requestModel.CompanyName = "";
        requestModel.CustomerName = "";
        requestModel.LoginID = "";
        requestModel.ActiveStatus = "";
        requestModel.MailingPhone = "";
        requestModel.MailingFax = "";
        requestModel.BusinessLicenseOrPermit = "";
        requestModel.CustomerFirstName = "";
        requestModel.CustomerLastName = "";
        requestModel.RegDate = "";
        requestModel.LastLogin= "";
        requestModel.BarcodeCustomerID = "";
        requestModel.ApprovalStatus = "";
        requestModel.UserRightsId = "";
        requestModel.DateTimeRegistered = "";
        requestModel.ApprovalFlag = "";
        requestModel.LoginCount = "";
        requestModel.LoginPassword= "";
        requestModel.Address = "";
        requestModel.CompanyId = "";
        requestModel.ShippingStreet = "";
        requestModel.ShippingStreet2 = "";
        requestModel.ShippingStateOrProvince = "";
        requestModel.ShippingCity = "";
        requestModel.ShippingCountry = "";
        requestModel.ShippingZipcode = "";
        requestModel.ShippingPhone = "";
        requestModel.SeekLevel = "";
        requestModel.CurrencyCode = "";
        requestModel.IsCODCustomer = "";
        requestModel.IsNET30Customer = "";
        requestModel.IsSubscribe = "";
        requestModel.MailingStreet = "";
        requestModel.MailingStreet1 = "";
        requestModel.MailingStreet= "";
        requestModel.MailingStateOrProvince = "";
        requestModel.MailingZipcode = "";
        requestModel.MailingCountry = "";
        requestModel.Note = "";
        requestModel.CompanyPhoneNumber = "";
        requestModel.CompanyPhone= "";
        requestModel.CompanyEmail = "";
        requestModel.Email = "";
        requestModel.ShippingAddressID = "";
        requestModel.CompanyCustomerType = "";
        requestModel.xmlns = "http://tempuri.org/";
        requestBody.requestAddCustomer = requestModel;
        requestEnvelope.body = requestBody;
        Call<AddCustomerResponseEnvelope> call = RetrofitGenerator.getApiService().addcustomerX(requestEnvelope);
        call.enqueue(new Callback<AddCustomerResponseEnvelope>() {
            @Override
            public void onResponse(Call<AddCustomerResponseEnvelope> call, Response<AddCustomerResponseEnvelope> response) {
                Toast.makeText(AddCustomer.this, "Customer Added Sucessfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<AddCustomerResponseEnvelope> call, Throwable t) {

            }
        });

    }
}