package com.example.makeuschallenge.src.login.select.signup.models;

import com.google.gson.annotations.SerializedName;

public class SignupResponse {


    @SerializedName("isSuccess")
    public boolean isSuccess;
    public boolean isSuccess() {
        return isSuccess;
    }

    @SerializedName("code")
    public int code;
    public int getCode() {
        return code;
    }

    @SerializedName("message")
    public String message;
    public String getMessage() {
        return message;
    }
}
