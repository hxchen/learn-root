package com.a3fun.learn.springevent.controller;

import com.a3fun.learn.springevent.service.UserService;
import com.a3fun.learn.springevent.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haixiangchen
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = "/register")
    public String register(){
        User user = new User(this);
        user.setId(10000L);
        user.setName("wayne");
        user.setAge(18);
        LOGGER.info(user.toString());
        userService.register(user);
        return user.toString();
    }
}
