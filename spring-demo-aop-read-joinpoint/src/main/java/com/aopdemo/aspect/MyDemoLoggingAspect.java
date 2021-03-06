package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    /*param pattern
            () - matches a method with no arguments
            (*) - matches a method with one argument of any type
            (..) - matches a method with 0 or more arguments of any type*/
    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("com.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=======>>> Execute @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        //get args
        Object[] args = joinPoint.getArgs();
        //loop args
        for (Object o : args) {
            System.out.println(o);
            if (o instanceof Account){
                //downcast and print Account stuff
                Account account = (Account) o;
                System.out.println("account name " + account.getName());
            }
        }

    }
}
