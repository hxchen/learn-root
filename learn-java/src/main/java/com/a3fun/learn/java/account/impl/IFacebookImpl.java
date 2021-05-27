package com.a3fun.learn.java.account.impl;

import com.a3fun.learn.java.account.Account;

/**
 * @author haixiangchen
 */
public class IFacebookImpl implements Account {
    @Override
    public void login() {
        System.out.println("facebook 账号登录");
    }
}
