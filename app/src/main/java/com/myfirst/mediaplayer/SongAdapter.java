package com.myfirst.mediaplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private ArrayList<SongModel> arrayList;
    private SongClickListener songClickListener;

    public SongAdapter(ArrayList<SongModel> arrayList,SongClickListener songClickListener){
        this.arrayList = arrayList;
        this.songClickListener = songClickListener;
    }

    @NonNull

    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_song,parent,false);
        return new SongViewHolder(view,songClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.setData(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
