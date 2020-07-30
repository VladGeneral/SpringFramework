package ru.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
    private Music music;
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
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

//    public MusicPlayer() {
//    }


//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

//    с autowired аннотацией название метода значения не имеет
//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }

    /*@Autowired
    public MusicPlayer(ClassicalMusic classicalMusic) {
        this.classicalMusic = classicalMusic;
    }*/

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic(){
//        System.out.println("Playing " + music.getSong());
//        musicList.forEach(x -> System.out.println(x.getSong()));
       return "Playing: " + classicalMusic.getSong();
    }
}
