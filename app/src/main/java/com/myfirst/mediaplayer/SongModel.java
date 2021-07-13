package com.myfirst.mediaplayer;

public class SongModel {
    private int songImage,songPath;
    private String songName,songDuration;

    public SongModel(int songImage, int songPath, String songName, String songDuration) {
        this.songImage = songImage;
        this.songPath = songPath;
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public int getSongImage() {
        return songImage;
    }

    public int getSongPath() {
        return songPath;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongDuration() {
        return songDuration;
    }
}
