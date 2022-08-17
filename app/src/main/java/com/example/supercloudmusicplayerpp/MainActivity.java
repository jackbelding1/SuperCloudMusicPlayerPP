package com.example.supercloudmusicplayerpp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String current_username;
    private int userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Bundle shared = getIntent().getExtras();

        if (shared != null) {
            userid = shared.getInt("userid");
            current_username = shared.getString("current_username", "username error");
        }
    }

    public void onSongInfo(View view){
        Intent intent = new Intent(this, MusicInfoActivity.class);
        startActivity(intent);

    }
}
