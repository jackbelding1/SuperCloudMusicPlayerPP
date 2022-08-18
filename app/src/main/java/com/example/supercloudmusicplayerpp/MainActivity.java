package com.example.supercloudmusicplayerpp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String current_username;
    private int userid;
    private MusicPlayer musicplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Bundle shared = getIntent().getExtras();

        if (shared != null) {
            userid = shared.getInt("userid");
            current_username = shared.getString("current_username", "username error");
        }

        // create Music player
        musicplayer = new MusicPlayer(getApplicationContext());
        initTable();
    }

    public void onSongInfo(View view){
        Intent intent = new Intent(this, MusicInfoActivity.class);
        Bundle bundle = new Bundle();
        musicplayer.getCurrentRecord().putToBundle("recordInfo", bundle);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void onPlayAndPause(View view){
        musicplayer.playMusic();
    }

    private void initTable(){
        TextView record1Title = (TextView) findViewById(R.id.record1Title);
        record1Title.setText(musicplayer.getTitleOf(0));
    }
}
