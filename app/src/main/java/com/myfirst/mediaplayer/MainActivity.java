package com.myfirst.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongClickListener {

    private RecyclerView mRecyclerView;
    private ArrayList<SongModel> arrayList = new ArrayList<>();
    private MediaPlayer mediaPlayer = new MediaPlayer();
    SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        setData();
        setAdapter();
    }

    private void setData() {
        for(int i=0;i<10;i++) {
            arrayList.add(new SongModel(R.drawable.bombaytopunab, R.raw.bombaytopunjab,
                    "Bombay to Punjab", "02:30"));
            arrayList.add(new SongModel(R.drawable.chittakurta, R.raw.chittakurta,
                    "Chitta Kurta", "02:40"));
            arrayList.add(new SongModel(R.drawable.compete, R.raw.compete,
                    "Compete", "03:30"));
            arrayList.add(new SongModel(R.drawable.dancelike, R.raw.dancelike,
                    "Dance Like", "02:30"));
            arrayList.add(new SongModel(R.drawable.daruband, R.raw.daruband,
                    "Daru Band", "02:50"));
            arrayList.add(new SongModel(R.drawable.defaulter, R.raw.defaulter,
                    "Defaulter", "02:10"));
            arrayList.add(new SongModel(R.drawable.dheeme, R.raw.dheeme,
                    "Dheeme Dheeme", "03:10"));
            arrayList.add(new SongModel(R.drawable.parche, R.raw.parche,
                    "8 Parche", "02:25"));
        }
    }
    public void setAdapter(){
        songAdapter = new SongAdapter(arrayList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setAdapter(songAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClickPlay(SongModel songModel) {
        if(mediaPlayer != null){
            onClickPause();
            onClickPlay(songModel);
        }
        else {
            mediaPlayer = MediaPlayer.create(this, songModel.getSongPath());
            mediaPlayer.start();
        }
    }

    @Override
    public void onClickPause() {
        mediaPlayer.pause();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public void onClickDelete(int position) {
        arrayList.remove(position);
        songAdapter.notifyDataSetChanged();
    }
}