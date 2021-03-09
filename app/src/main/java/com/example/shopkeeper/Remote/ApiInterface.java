package com.example.shopkeeper.Remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


}
