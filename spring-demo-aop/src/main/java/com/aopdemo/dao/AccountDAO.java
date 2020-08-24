package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": DOING MY DB WORD: ADDING AN ACCOUNT");
    }
}
