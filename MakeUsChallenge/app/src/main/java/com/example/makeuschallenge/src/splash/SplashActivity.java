package com.example.makeuschallenge.src.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.login.LoginActivity;
import com.example.makeuschallenge.src.main.MainActivity;
import com.example.makeuschallenge.src.main.chatting.ChattingActivity;
import com.example.makeuschallenge.src.video.VideoActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(),3000);

        ImageView imageView = findViewById(R.id.splash_icon);


//        Animation slowly_appear,slowlyDisappear;
//        slowlyDisappear = AnimationUtils.loadAnimation(this,R.anim.fadeout);
//        slowly_appear = AnimationUtils.loadAnimation(this,R.anim.fadein);
//        imageView.setAnimation(slowlyDisappear);
//        imageView.setAnimation(slowly_appear);

        this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);


    }
    private class SplashHandler implements Runnable{
        @Override
        public void run() {
            //TODO 원래 LoginActivity,
            startActivity(new Intent(getApplication(), VideoActivity.class));
            SplashActivity.this.finish(); //로딩페이지를 액티비티 스택에서 제거거
        }
    }

    @Override
    public void onBackPressed(){
        //초반 플래시 화면에서 넘어갈때 뒤로가게 버튼 못누르게
    }



}

