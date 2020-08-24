package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    //add a new mthod findaccounts
    public List<Account> findAccounts(boolean tripWire){
        List<Account> accounts = new ArrayList<>();

        //simulate an exception
        if (tripWire){
            throw new RuntimeException("exception bbbbb");
        }

        //create sample accounts
        Account account1 = new Account("sss1", "silver");
        Account account2 = new Account("sss2", "platinum");
        Account account3 = new Account("sss3", "gold");

        //add them to our account list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in SetName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": DOING MY DB WORD: ADDING AN ACCOUNT");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
