package com.example.makeuschallenge.src.video.interfaces;

import com.example.makeuschallenge.src.video.models.VideoResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VideoRetrofitInterface {

    @GET("/study/1")
    Call<VideoResponse> getMovieChart();



}
