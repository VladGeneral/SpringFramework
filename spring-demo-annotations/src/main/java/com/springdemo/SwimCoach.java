package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
//    @Value("${foo.email}")
//    private String email;
//
//    @Value("${foo.team}")
//    private String team;

    private FortuneService fortuneService;


    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "swim 10 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
