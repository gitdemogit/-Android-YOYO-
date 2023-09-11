package com.example.smartflower.tools;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Flower {
    private String name;
    private String fs;
    private int fp;

    public String getName(){return name;}
    public String getFs(){return  fs;}
    public int getFp(){return fp;}

    public Flower(String name, String fs, int fp){
        this.fp=fp;
        this.name=name;
        this.fs=fs;
    }
}
