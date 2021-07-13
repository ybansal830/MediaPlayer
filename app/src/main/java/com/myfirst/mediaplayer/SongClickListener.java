package com.myfirst.mediaplayer;

public interface SongClickListener {
    void onClickPlay(SongModel songModel);
    void onClickPause();
    void onClickDelete(int position);
}
