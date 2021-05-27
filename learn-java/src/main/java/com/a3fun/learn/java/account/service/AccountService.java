package com.a3fun.learn.java.account.service;

import com.a3fun.learn.java.account.Account;
import com.a3fun.learn.java.account.impl.IFacebookImpl;
import com.a3fun.learn.java.account.impl.IGoogleImpl;

/**
 * @author haixiangchen
 */
public class AccountService {

    private static volatile AccountService instance;
    public static AccountService getInstance(){
        if(instance == null){
            synchronized (AccountService.class){
                if(instance == null){
                    instance = new AccountService();
                }
            }
        }

        return instance;
    }

    public Account getAccountById(int id){
        Account account = null;
        switch (id){
            case 1:
                account =  new IFacebookImpl();
                break;
            case 2:
                account = new IGoogleImpl();
                break;
            default:
        }
        return account;
    }
}
