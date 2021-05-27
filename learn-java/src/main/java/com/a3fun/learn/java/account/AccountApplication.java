package com.a3fun.learn.java.account;

import com.a3fun.learn.java.account.service.AccountService;

/**
 * @author haixiangchen
 */
public class AccountApplication {

    public static void main(String[] args) {
        Account account = AccountService.getInstance().getAccountById(2);
        account.login();
    }
}
