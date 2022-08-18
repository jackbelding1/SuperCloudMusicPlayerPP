package com.example.supercloudmusicplayerpp;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private MediaPlayer mp;
    private ArrayList<Record> recordBox = new ArrayList<>();
    private int currentRecord;

    // constructor
    public MusicPlayer(Context mainActivityContext){
        init(mainActivityContext);
    }

    private void init(Context mainActivityContext){
        // initialize the record box
        initializeRecordBox();
        // add the first record as default track
        currentRecord = 0;
        mp = MediaPlayer.create(mainActivityContext, recordBox.get(currentRecord).getResource());
    }

    public void playMusic(){
        mp.start();
    }

    private void initializeRecordBox(){
        Record record = new Record();
        recordBox.add(record);
    }

    public Record getCurrentRecord(){
        return recordBox.get(currentRecord);
    }

    public String getTitleOf(int recordID){
        return  recordBox.get(recordID).getTitle();
    }
}
