package com.myfirst.mediaplayer;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvSong;
    private TextView mTvSong,mTvDuration;
    private Button mBtPlay,mBtPause,mBtDelete;
    private SongClickListener songClickListener;

    public SongViewHolder(@NonNull View itemView,SongClickListener songClickListener) {
        super(itemView);
        this.songClickListener = songClickListener;
        initViews();
    }

    public void setData(SongModel songModel) {
        mIvSong.setImageResource(songModel.getSongImage());
        mTvSong.setText(songModel.getSongName());
        mTvDuration.setText(songModel.getSongDuration());
        mBtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songClickListener.onClickPlay(songModel);
            }
        });
        mBtPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songClickListener.onClickPause();
            }
        });
        mBtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songClickListener.onClickDelete(getAdapterPosition());
            }
        });
    }

    private void initViews() {
        mIvSong = itemView.findViewById(R.id.ivSong);
        mTvSong = itemView.findViewById(R.id.tvSong);
        mTvDuration = itemView.findViewById(R.id.tvDuration);
        mBtPlay = itemView.findViewById(R.id.btPlay);
        mBtPause = itemView.findViewById(R.id.btPause);
        mBtDelete = itemView.findViewById(R.id.btDelete);
    }
}
