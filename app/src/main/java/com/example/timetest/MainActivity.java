package com.example.timetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;

import org.litepal.LitePal;
import org.litepal.exceptions.DataSupportException;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
//public String time_record;
private TextClock time;
private List<Time> timeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.time);
        TimeZone.getDefault().getDisplayName(true, TimeZone.SHORT);
        //time_record = (String) time.getText();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TimeAdapter adapter = new TimeAdapter(timeList);
        recyclerView.setAdapter(adapter);

        LitePal.getDatabase();
        Button record = findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Time time_new = new Time();
                time_new.setTime(time.getText().toString());
                timeList.add(time_new);
                adapter.notifyDataSetChanged();
                //LitePal.getDatabase();
                //Time time_re = new Time();
                //time_re.setTime((String) time.getText());
                Time time_re = new Time();
                time_re.setTime((String) time.getText());
                time_re.save();
            }
        });
        Button list = findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeList.clear();
                adapter.notifyDataSetChanged();
                List<Time> times = LitePal.findAll(Time.class);
                for(int i = 1;i<=times.size();i++){
                    Time time_old = LitePal.find(Time.class,i);
                    timeList.add(time_old);
                    adapter.notifyDataSetChanged();
                }


            }
        });
        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    
}//使用LitePal存储，显示的时候查询一下