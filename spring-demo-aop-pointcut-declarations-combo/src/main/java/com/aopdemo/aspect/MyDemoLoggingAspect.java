package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    private void setter(){}

    //combine pointcut
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>> Execute @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=======>>> Performing API analytics");
    }
}
