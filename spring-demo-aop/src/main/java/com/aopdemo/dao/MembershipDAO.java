package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount(){
        System.out.println(getClass() + ": DOING MY DB WORD: ADDING AN ACCOUNT");
    }
}
