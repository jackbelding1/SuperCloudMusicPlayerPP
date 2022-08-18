package com.example.supercloudmusicplayerpp;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private MediaPlayer mp;
    private ArrayList<Record> recordBox = new ArrayList<>();

    // constructor
    public MusicPlayer(Context mainActivityContext){
        init(mainActivityContext);
    }

    private void init(Context mainActivityContext){
        // initialize the record box
        initializeRecordBox();
        // add the first record as default track
        mp = MediaPlayer.create(mainActivityContext, recordBox.get(0).getResource());
    }

    public void playMusic(){
        mp.start();
    }

    private void initializeRecordBox(){
        Record record = new Record();
        recordBox.add(record);
    }
}
