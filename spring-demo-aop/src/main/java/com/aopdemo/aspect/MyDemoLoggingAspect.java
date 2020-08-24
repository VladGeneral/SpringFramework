package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    /*param pattern
            () - matches a method with no arguments
            (*) - matches a method with one argument of any type
            (..) - matches a method with 0 or more arguments of any type*/
    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
//    @Before("execution(public void add*())")

    @Before("execution(* add*(com.aopdemo.Account, ..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>> Execute @Before advice on addAccount()");
    }
}
