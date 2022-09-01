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


    public void init(){
        //
        // TODO: initialize from db
        //
        params = new Record.Paramenters();
        resource = R.raw.track1;
        title = "Kill My Love";
        artist = "Sam Divine ft. Amy Lyon";
        label = "DVINE Sounds";
        length = "5:41";
    }

    public int getResource(){
        return resource;
    }

    public String getTitle() { return title;}
    public String getArtist() { return artist;}
    public  String getLabel() {return label;}
    public String getLength() {return length;}

    public static class Paramenters implements Serializable{
        private String title;
        private int plays;
        private String artist;
        private String label;
        private String length;
    }

    public void putToBundle(String key, Bundle bundle){
        params.artist = artist;
        params.label = label;
        params.length = length;
//        params.plays = plays;
        params.title = title;
        bundle.putSerializable(key, params);
    }
    public void getFromBundle(String key, Bundle bundle){
        params = (Record.Paramenters) bundle.getSerializable(key);
        title = params.title;
        artist = params.artist;
        label = params.label;
        length = params.length;
    }
}
