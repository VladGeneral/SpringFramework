package ru.springframework;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
//    private Music music;
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer() {
    }

//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

//    public void setMusic(Music music) {
//        this.music = music;
//    }

    public void playMusic(){
//        System.out.println("Playing " + music.getSong());
        musicList.forEach(x -> System.out.println(x.getSong()));
    }
}
