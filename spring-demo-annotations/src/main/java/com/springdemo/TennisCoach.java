package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//default tennisCoach
@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach inside default constructor");
    }

    //define my init method
    @PostConstruct
    public void doInit(){
        System.out.println(">> TennisCoach: inside of doInit()");
    }
    //define my destroy method
    @PreDestroy
    public void doDestroy(){
        System.out.println(">> TennisCoach: inside of doDestroy()");
    }

    //if we will remove annotation, spring still work. as of spring 4.3 if we have one constructor autowired no longer needed
    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/


    //define a setter method
    /*@Autowired
    public void setFortuneService(@Qualifier("randomFortuneService")FortuneService fortuneService) {
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
