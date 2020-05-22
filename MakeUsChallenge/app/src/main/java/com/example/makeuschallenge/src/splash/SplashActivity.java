package com.example.makeuschallenge.src.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.login.LoginActivity;
import com.example.makeuschallenge.src.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(),2000);


    }
    private class SplashHandler implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish(); //로딩페이지를 액티비티 스택에서 제거거
        }
    }

    @Override
    public void onBackPressed(){
        //초반 플래시 화면에서 넘어갈때 뒤로가게 버튼 못누르게
    }



}

