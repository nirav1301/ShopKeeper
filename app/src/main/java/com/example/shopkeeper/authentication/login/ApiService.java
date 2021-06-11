package com.example.shopkeeper.authentication.login;

import com.example.shopkeeper.addcustomer.request.AddCustomerRequestEnvelope;
import com.example.shopkeeper.addcustomer.response.AddCustomerResponseEnvelope;
import com.example.shopkeeper.authentication.login.request.LoginRequestEnvelope;
import com.example.shopkeeper.authentication.login.response.LoginResponseEnvelope;
import com.example.shopkeeper.createorder.request.CreateOrderRequestEnvelope;
import com.example.shopkeeper.createorder.response.CreateOrderResponseEnvelope;
import com.example.shopkeeper.findcustomer.request.FindCustomerRequestEnvelope;
import com.example.shopkeeper.findcustomer.response.FindCustomerResponseEnvelope;
import com.example.shopkeeper.forgotpassword.request.ForgotPassRequestEnvelope;
import com.example.shopkeeper.forgotpassword.response.ForgotPasswordResponseEnvelope;
import com.example.shopkeeper.orderhistory.request.OrderHistoryRequestEnvelope;
import com.example.shopkeeper.orderhistory.response.OrderHistoryResponseEnvelope;
import com.example.shopkeeper.recentorder.request.RecentOrderRequestEnvelope;
import com.example.shopkeeper.recentorder.response.RecentOrderResponseEnvelope;
import com.example.shopkeeper.sendinvoice.request.SendInvoiceRequestEnvelope;
import com.example.shopkeeper.sendinvoice.response.SendInvoiceResponseEnvelope;
import com.example.shopkeeper.sendorder.request.SendOrderRequestEnvelope;
import com.example.shopkeeper.sendorder.response.SendOrderResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
//    @Headers({
//            "Content-Type: text/xml;charset=UTF-8",
//            "SOAPAction: http://tempuri.org/ForgotPasswordEmail"}
//    )
//
//    @POST("myservice.asmx")
//    Call<ForgotPasswordResponseEnvelope> forgotPasswordEmailX(@Body ForgotPassRequestEnvelope forgotPassRequestEnvelope);


    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/ValidateUser"}
    )
    @POST("myservice.asmx")
    Call<LoginResponseEnvelope> validateUserX(@Body LoginRequestEnvelope loginRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/ForgotPasswordEmail"}
    )

    @POST("myservice.asmx")
    Call<ForgotPasswordResponseEnvelope> forgotPasswordEmailX(@Body ForgotPassRequestEnvelope forgotPassRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/GetRecentOrders"}
    )
    @POST("myservice.asmx")
    Call<RecentOrderResponseEnvelope> recentOrderX(@Body RecentOrderRequestEnvelope recentOrderRequestEnvelope);
    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/GetOrderHistry"}
    )
    @POST("myservice.asmx")
    Call<OrderHistoryResponseEnvelope> orderHistoryX(@Body OrderHistoryRequestEnvelope orderHistoryRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/GetProductDetailByProductCode"}
    )
    @POST("myservice.asmx")
    Call<CreateOrderResponseEnvelope> createOrderX(@Body CreateOrderRequestEnvelope createOrderRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/FindCustomer"}
    )
    @POST("myservice.asmx")
    Call<FindCustomerResponseEnvelope> findCutomerX(@Body FindCustomerRequestEnvelope findCustomerRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/EmailPlaceOrder"}
    )
    @POST("myservice.asmx")
    Call<SendInvoiceResponseEnvelope> sendinvoiceX(@Body SendInvoiceRequestEnvelope sendInvoiceRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/SendOrder"}
    )
    @POST("myservice.asmx")
    Call<SendOrderResponseEnvelope> sendorderX(@Body SendOrderRequestEnvelope sendOrderRequestEnvelope);

    @Headers({
            "Content-Type: text/xml;charset=UTF-8",
            "SOAPAction: http://tempuri.org/SendOrder"}
    )
    @POST("myservice.asmx")
    Call<AddCustomerResponseEnvelope> addcustomerX(@Body AddCustomerRequestEnvelope addCustomerRequestEnvelope);


}



