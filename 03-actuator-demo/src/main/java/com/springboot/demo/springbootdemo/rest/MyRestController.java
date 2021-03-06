package com.springboot.demo.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return coachName + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "hello world, time on the server is " + LocalDateTime.now();
    }

    //registry auto update classes https://stackoverflow.com/questions/33869606/intellij-15-springboot-devtools-livereload-not-working
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5K";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "today is you lucky day!";
    }
}
