package com.example.supercloudmusicplayerpp;

import android.os.Bundle;
import android.widget.GridLayout;

import java.io.Serializable;

public class Record {
    private String title;
    private int plays;
    private String artist;
    private String label;
    private String length;
    private int resource;
    private Record.Paramenters params;

    public Record(){
        init();
    }

    private void init(){
        params = new Record.Paramenters();
        resource = R.raw.track1;
        title = "Kill My Love";
    }

    public int getResource(){
        return resource;
    }

    public String getTitle() { return title;}

    public static class Paramenters implements Serializable{
        private String title;
        private int plays;
        private String artist;
        private String label;
        private String length;
    }

    public void putToBundle(String key, Bundle bundle){
//        params.artist = artist;
//        params.label = label;
//        params.length = length;
//        params.plays = plays;
        params.title = title;
        bundle.putSerializable(key, params);
    }
    public void getFromBundle(String key, Bundle bundle){
        params = (Record.Paramenters) bundle.getSerializable(key);
        title = params.title;
//        artist = params.artist;
//        label = params.label;
//        length = params.length;
    }
}
