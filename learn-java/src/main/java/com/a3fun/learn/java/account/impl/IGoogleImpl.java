package com.a3fun.learn.java.account.impl;

import com.a3fun.learn.java.account.Account;

/**
 * @author haixiangchen
 */
public class IGoogleImpl implements Account {
    @Override
    public void login() {
        System.out.println("google 登录");
    }
}
