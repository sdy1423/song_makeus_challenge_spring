package com.example.calendar_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);

    }
}
