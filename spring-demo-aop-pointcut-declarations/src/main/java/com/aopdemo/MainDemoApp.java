package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call the business method
        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        membershipDAO.addMember();
        membershipDAO.goToSleep();

        //close the context
        context.close();
    }
}
