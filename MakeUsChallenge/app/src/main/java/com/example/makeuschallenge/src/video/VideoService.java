package com.example.makeuschallenge.src.video;

import android.util.Log;

import com.example.makeuschallenge.src.video.interfaces.VideoAcitivityView;
import com.example.makeuschallenge.src.video.interfaces.VideoRetrofitInterface;
import com.example.makeuschallenge.src.video.models.VideoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.makeuschallenge.src.ApplicationClass.getRetrofit;

public class VideoService {
    VideoAcitivityView videoAcitivityView;

    public VideoService(VideoAcitivityView videoAcitivityView) {
        this.videoAcitivityView = videoAcitivityView;
    }


    public void getVideo(){
        VideoRetrofitInterface videoRetrofitInterface = getRetrofit().create(VideoRetrofitInterface.class);
        videoRetrofitInterface.getMovieChart().enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {

                if (response.body() != null) {

                    Log.e("responst", String.valueOf(response.body().getResult()));
                    videoAcitivityView.getVideoSucces(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {

            }
        });
    }
}
