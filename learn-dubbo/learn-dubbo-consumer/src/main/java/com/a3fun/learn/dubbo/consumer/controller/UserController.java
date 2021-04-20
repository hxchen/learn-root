package com.a3fun.learn.dubbo.consumer.controller;

import com.a3fun.learn.dubbo.api.entity.User;
import com.a3fun.learn.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haixiangchen
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/findUser")
    public User findUserById(String id){
        return userService.getUserById(Long.parseLong(id));
    }

}
