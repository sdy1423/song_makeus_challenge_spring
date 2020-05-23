package com.example.makeuschallenge.src.video.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoResponse {

    @SerializedName("result")
    public ArrayList<Result> result;

    @SerializedName("isSuccess")
    public boolean isSuccess;

    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;


    public boolean getIsSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Result> getResult() {
        return result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public class Result{

        @SerializedName("idStudyList")
        public int idStudyList;

        @SerializedName("studyName")
        public String studyName;

        @SerializedName("studyOwner")
        public String studyOwner;

        @SerializedName("studyUrl")
        public String studyUrl;

        public int getIdStudyList() {
            return idStudyList;
        }

        public String getStudyName() {
            return studyName;
        }

        public String getStudyOwner() {
            return studyOwner;
        }

        public String getStudyUrl() {
            return studyUrl;
        }
    }

}
