package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember(){
        System.out.println(getClass() + ": DOING MY DB WORD: ADDING AN ACCOUNT");
        return true;
    }

    public boolean goToSleep(){
        System.out.println(getClass() + ": goToSleep()");
        return false;
    }
}
