package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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
            if (o instanceof Account) {
                //downcast and print Account stuff
                Account account = (Account) o;
                System.out.println("account name " + account.getName());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n====>>> result is: " + result);

        //lets post process the data... modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n====>>> result is: " + result);
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
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n====>>> Exception is: " + exc);
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
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);
    }
}
