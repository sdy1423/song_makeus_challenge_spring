package com.example.makeuschallenge.src.video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.BaseActivity;
import com.example.makeuschallenge.src.login.LoginActivity;
import com.example.makeuschallenge.src.video.interfaces.VideoAcitivityView;
import com.example.makeuschallenge.src.video.models.VideoResponse;

import java.util.ArrayList;

public class VideoActivity extends BaseActivity implements VideoAcitivityView {


    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoService videoService = new VideoService(this);
        videoService.getVideo();
        videoView = (VideoView)findViewById(R.id.video);




    }

    @Override
    public void getVideoSucces(ArrayList<VideoResponse.Result> result) {

        String url = result.get(0).getStudyUrl();

        videoView.setVideoPath(url);
        videoView.start();
    }

    @Override
    public void getVideoFail() {

    }
}
