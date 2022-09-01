package com.example.supercloudmusicplayerpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class MusicInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);
        Bundle bundle = getIntent().getExtras();
        Record record = new Record();
        record.getFromBundle("recordInfo", bundle);
        init(record);
    }

    public void onBackButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void init(Record record){
        TextView title = (TextView) findViewById(R.id.recordTitle);
        title.setText(record.getTitle());

        TextView artist = (TextView) findViewById(R.id.recordArtist);
        artist.setText(record.getArtist());

        TextView label = (TextView) findViewById(R.id.recordLabel);
        label.setText(record.getLabel());

        TextView length = (TextView) findViewById(R.id.recordLength);
        length.setText(record.getLength());


    }
}