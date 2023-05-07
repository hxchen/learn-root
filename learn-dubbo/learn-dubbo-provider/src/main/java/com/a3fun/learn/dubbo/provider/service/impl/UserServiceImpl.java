package com.a3fun.learn.dubbo.provider.service.impl;

import com.a3fun.learn.dubbo.api.entity.User;
import com.a3fun.learn.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Long id) {
        return new User(1L, "John");
    }
}
