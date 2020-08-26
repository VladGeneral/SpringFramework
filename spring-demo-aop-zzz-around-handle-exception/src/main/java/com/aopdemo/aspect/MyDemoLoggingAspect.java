package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());
    /*param pattern
            () - matches a method with no arguments
            (*) - matches a method with one argument of any type
            (..) - matches a method with 0 or more arguments of any type*/
    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("com.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n=======>>> Execute @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSignature);

        //display method arguments

        //get args
        Object[] args = joinPoint.getArgs();
        //loop args
        for (Object o : args) {
            logger.info(o.toString());
            if (o instanceof Account) {
                //downcast and print Account stuff
                Account account = (Account) o;
                logger.info("account name " + account.getName());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterReturning on method: " + method);

        logger.info("\n====>>> result is: " + result);

        //lets post process the data... modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        logger.info("\n====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for (Account account : result) {
            //get uppercase version of name
            //update the name on the account
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterThrowing on method: " + method);

        logger.info("\n====>>> Exception is: " + exc);
    }

   /* Starting with Spring 5.2.7:
            - if advice methods defined in the same
        @Aspect class that need to run at the same join point

- the @After advice method is invoked AFTER any
    @AfterReturning or @AfterThrowing advice methods in
    the same aspect class*/

    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @Around on method: " + method);
        //get begin timestap
        long begin = System.currentTimeMillis();

        //execute method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            //log
            logger.warning("logger warning - " + e.getMessage());
            //give user a custom message
            result = "Major accident! But no worries";
        }

        //get end timestap
        long end = System.currentTimeMillis();
        //compute duration and display it
        long duration = end - begin;
        logger.info("\n======> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }
}
