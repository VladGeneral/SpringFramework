package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//default tennisCoach
@Component
public class TennisCoach implements Coach {
    @Autowired
    private FortuneService fortuneService;

    //if we will remove annotation, spring still work. as of spring 4.3 if we have one constructor autowired no longer needed
    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    public TennisCoach() {
        System.out.println(">> TennisCoach inside default constructor");
    }


    //define a setter method
    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach inside setFortuneService");
        this.fortuneService = fortuneService;
    }*/

    //define a some method
    /*@Autowired
    public void doSomething(FortuneService fortuneService) {
        System.out.println(">> TennisCoach inside doSomething method");
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
