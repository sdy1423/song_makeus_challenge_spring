package com.example.makeuschallenge.src.video.interfaces;

import com.example.makeuschallenge.src.video.models.VideoResponse;

import java.util.ArrayList;

public interface VideoAcitivityView {
    void getVideoSucces(ArrayList<VideoResponse.Result> result);
    void getVideoFail();
}
