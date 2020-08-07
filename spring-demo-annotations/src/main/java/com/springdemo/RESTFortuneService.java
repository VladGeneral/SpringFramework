package com.springdemo;

import org.springframework.stereotype.Component;

//no conversion to RestFortuneService
@Component
public class RESTFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return null;
    }
}
