package com.a3fun.learn.dubbo.provider.service.impl;

import com.a3fun.learn.dubbo.api.entity.User;
import com.a3fun.learn.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service()
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(long id) {
        User user = new User();
        user.setName("test");
        user.setId(id);
        return user;
    }
}
