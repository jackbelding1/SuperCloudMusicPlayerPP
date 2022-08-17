package com.example.supercloudmusicplayerpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MusicInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);
    }

    public void onBackButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}