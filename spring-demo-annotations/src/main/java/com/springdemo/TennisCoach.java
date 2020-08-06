package com.springdemo;

import org.springframework.stereotype.Component;
//default tennisCoach
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley";
    }
}
