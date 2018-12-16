package com.example.kimsm.buskingproject;

import android.graphics.drawable.Drawable;

public class ListViewItem {

    private Drawable icon;
    private String time;
    private String explain;

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setExplain(String explain){
        this.explain = explain;
    }
    public Drawable getIcon(){
        return this.icon;
    }
    public String getTime(){
        return this.time;
    }
    public String getExplain(){
        return  this.explain;
    }

}
