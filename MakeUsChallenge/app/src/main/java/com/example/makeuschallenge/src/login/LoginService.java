package com.example.makeuschallenge.src.login;

import com.example.makeuschallenge.src.login.interfaces.LoginActivityVIew;
import com.example.makeuschallenge.src.login.interfaces.LoginRetrofitInterfaces;
import com.example.makeuschallenge.src.login.models.LoginResponse;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.makeuschallenge.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.makeuschallenge.src.ApplicationClass.getRetrofit;

public class LoginService {
    private final LoginActivityVIew loginActivityVIew;


    public LoginService(LoginActivityVIew loginActivityVIew) {
        this.loginActivityVIew = loginActivityVIew;
    }

    private void postLogin(String name,String email,String sns) throws JSONException{
        JSONObject params = new JSONObject();
        params.put("name",name);
        params.put("email",email);
        params.put("sns",sns);

        final LoginRetrofitInterfaces loginRetrofitInterfaces = getRetrofit().create(LoginRetrofitInterfaces.class);

        loginRetrofitInterfaces.PostLogIn(RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}
