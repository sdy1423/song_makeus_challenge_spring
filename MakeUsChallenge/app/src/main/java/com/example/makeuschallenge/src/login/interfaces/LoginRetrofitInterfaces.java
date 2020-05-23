package com.example.makeuschallenge.src.login.interfaces;

import com.example.makeuschallenge.src.login.models.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRetrofitInterfaces {
    @POST("/jwt")
    Call<LoginResponse> PostLogIn(
            @Body RequestBody params
    );


}
