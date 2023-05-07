package com.a3fun.learn.dubbo.api.service;

import com.a3fun.learn.dubbo.api.entity.User;

public interface UserService {
    User findUserById(Long id);
}
