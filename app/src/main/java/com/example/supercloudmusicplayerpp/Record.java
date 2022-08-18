package com.example.supercloudmusicplayerpp;

public class Record {
    private String title;
    private int plays;
    private String artist;
    private String label;
    private String length;
    private int resource;

    public Record(){
        init();
    }

    private void init(){
        resource = R.raw.track1;
    }

    public int getResource(){
        return resource;
    }
}
