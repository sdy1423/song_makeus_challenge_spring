package com.example.makeuschallenge.src.main.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.main.first.FirstActivity;

public class HomeFragment extends Fragment {
    ImageView mIvBanner1,mIvBanner2,mIvBanner3,mIvBanner4,mIvBanner5,mIvBanner6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mIvBanner1=rootView.findViewById(R.id.banner1);
        mIvBanner2=rootView.findViewById(R.id.banner2);
        mIvBanner3=rootView.findViewById(R.id.banner3);
        mIvBanner4=rootView.findViewById(R.id.banner4);
        mIvBanner5=rootView.findViewById(R.id.banner5);
        mIvBanner6=rootView.findViewById(R.id.banner6);

        mIvBanner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO firstactivity로 이동
                Intent intent = new Intent(getActivity(), FirstActivity.class);
                startActivity(intent);

            }
        });



        return rootView;
    }
}
