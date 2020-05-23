package com.example.makeuschallenge.src.login.select.signup;

import com.example.makeuschallenge.src.login.select.signup.interfaces.SignupActivityView;
import com.example.makeuschallenge.src.login.select.signup.interfaces.SignupRetrofitInterfaces;
import com.example.makeuschallenge.src.login.select.signup.models.SignupResponse;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.makeuschallenge.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.makeuschallenge.src.ApplicationClass.getRetrofit;

public class SignupService {
    private final SignupActivityView signupActivityView;


    public SignupService(SignupActivityView signupActivityView) {
        this.signupActivityView = signupActivityView;
    }

        public void PostSignUp(String name,String id,String pw) throws JSONException{
            JSONObject params = new JSONObject();
            params.put("name", name);
            params.put("id",id);
            params.put("pw",pw);

            final SignupRetrofitInterfaces signupRetrofitInterfaces = getRetrofit().create(SignupRetrofitInterfaces.class);
        signupRetrofitInterfaces.PostSignUp(RequestBody.create(params.toString(),MEDIA_TYPE_JSON)).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                signupActivityView.postSignupSuccess();

            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {

                signupActivityView.postSignupFail();
            }
        });
    }



}
