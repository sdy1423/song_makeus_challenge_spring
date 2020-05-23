package com.example.makeuschallenge.src.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.BaseActivity;
import com.example.makeuschallenge.src.main.home.HomeFragment;
import com.example.makeuschallenge.src.main.lecture.LectureFragment;
import com.example.makeuschallenge.src.main.profile.ProfileFragment;
import com.example.makeuschallenge.src.main.talk.TalkFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private LectureFragment lectureFragment = new LectureFragment();
    private TalkFragment talkFragment = new TalkFragment();
    private ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bottom_navigation);
        //첫 화면 지정
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout,homeFragment).commitAllowingStateLoss();

        //bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.navigation_menu1:
                        transaction.replace(R.id.main_frame_layout,homeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_menu2:
                        transaction.replace(R.id.main_frame_layout,lectureFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_menu3:
                        transaction.replace(R.id.main_frame_layout,talkFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_menu4:
                        transaction.replace(R.id.main_frame_layout,profileFragment).commitAllowingStateLoss();
                        break;

                }
                return true;
            }
        });


    }
}
