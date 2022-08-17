package com.example.supercloudmusicplayerpp;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicPlayer {
    private MediaPlayer mp;


    // constructor
    public MusicPlayer(Context mainActivityContext){
        mp = MediaPlayer.create(mainActivityContext, R.raw.track1);
    }

    private void init(){

    }

    public void playMusic(){
        mp.start();
    }
}
