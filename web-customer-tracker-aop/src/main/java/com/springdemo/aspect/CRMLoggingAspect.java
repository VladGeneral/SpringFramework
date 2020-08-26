package com.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcuts
    @Pointcut("execution(* com.springdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }

    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private void forServicePackage(){

    }

    @Pointcut("execution(* com.springdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){

    }

    //add @Before
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display method
        logger.info("\n=====>>> in @Before: calling method: " + joinPoint.getSignature().toShortString());

        //display the arguments
    }

    //add @AfterReturning advice
}
