package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call method to find the accounts
        List<Account> accounts = null;
        try {
            //add a boolean flag to simulate exception
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //display the accounts
        System.out.println("\nMain Program: AfterReturningDemoApp");
        System.out.println("------");
        System.out.println(accounts);
        System.out.println("\n");

        //close the context
        context.close();
    }
}
