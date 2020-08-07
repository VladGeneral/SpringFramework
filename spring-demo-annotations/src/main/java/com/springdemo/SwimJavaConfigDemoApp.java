package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        //read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on the bean
        System.out.println(coach.getDailyWorkout());

        //call method to get daily fortune
        System.out.println(coach.getDailyFortune());

        //properties
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());

        //close the context
        context.close();
    }
}
