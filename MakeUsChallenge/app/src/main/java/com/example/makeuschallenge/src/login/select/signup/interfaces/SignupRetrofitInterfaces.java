package com.example.makeuschallenge.src.login.select.signup.interfaces;


import com.example.makeuschallenge.src.login.select.signup.models.SignupResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignupRetrofitInterfaces {

    @POST("/user")
    Call<SignupResponse> PostSignUp(
            @Body RequestBody requestBody
    );


}
