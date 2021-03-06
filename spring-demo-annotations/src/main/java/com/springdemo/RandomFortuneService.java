package com.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    //create an array of strings
    private String[] data = {
            "Beware of the wolf in cheeps clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    @Override
    public String getFortune() {
        //pick a random string from the array
        return data[new Random().nextInt(data.length)];
    }
}
