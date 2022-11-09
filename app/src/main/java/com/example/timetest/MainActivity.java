package com.example.timetest;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextClock;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextClock time = findViewById(R.id.time);
        //time.setTimeZone("Asia/Beijing");
        TimeZone.getDefault().getDisplayName(true, TimeZone.SHORT);
    }
}