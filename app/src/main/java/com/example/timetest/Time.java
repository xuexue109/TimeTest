package com.example.timetest;

import org.litepal.crud.LitePalSupport;

public class Time extends LitePalSupport {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
