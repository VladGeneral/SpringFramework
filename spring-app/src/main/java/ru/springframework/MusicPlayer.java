package ru.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {
//    @Autowired
//    @Qualifier("classicalMusic")
    private Music music1;
    private Music music2;
//    private ClassicalMusic classicalMusic;
//    private RockMusic rockMusic;
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

    /*Начиная со Spring версии 4.3, если в вашем классе есть только один конструктор,
    можно не ставить аннотацию @Autowired на него и Spring будет по умолчанию внедрять
    зависимости через этот конструктор.*/
    /*@Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }*/
    @Autowired
    public MusicPlayer(
            @Qualifier("classicalMusic") Music music1,
            @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic(){
//        System.out.println("Playing " + music.getSong());
//        musicList.forEach(x -> System.out.println(x.getSong()));
       return "Playing: " + music1.getSong() + " and " + music2.getSong();
    }
}
