package com.example.shopkeeper.authentication.Login;

import com.example.shopkeeper.authentication.Login.Request.LoginRequestEnvelope;
import com.example.shopkeeper.authentication.Login.Response.LoginResponseEnvelope;
import com.example.shopkeeper.createorder.Request.CreateOrderRequestEnvelope;
import com.example.shopkeeper.createorder.Response.CreateOrderResponseEnvelope;
import com.example.shopkeeper.findcustomer.Request.FindCustomerRequestEnvelope;
import com.example.shopkeeper.findcustomer.Response.FindCustomerResponseEnvelope;
import com.example.shopkeeper.orderhistory.Request.OrderHistoryRequestEnvelope;
import com.example.shopkeeper.orderhistory.Response.OrderHistoryResponseEnvelope;
import com.example.shopkeeper.recentorder.request.RecentOrderRequestEnvelope;
import com.example.shopkeeper.recentorder.response.RecentOrderResponseEnvelope;

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

}



