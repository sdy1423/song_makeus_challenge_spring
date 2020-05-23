package com.example.makeuschallenge.src.main.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.login.select.SelectActivity;
import com.example.makeuschallenge.src.main.chatting.ChattingActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ImageView imageView = findViewById(R.id.go_chatting);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ChattingActivity.class);
                startActivity(intent);//액티비티 띄우기

            }
        });

    }
}
