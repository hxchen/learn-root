package com.a3fun.learn.springevent.service;

import com.a3fun.learn.springevent.vo.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author haixiangchen
 */
@Service
public class UserService {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void register(UserRegisterEvent user){
        publisher.publishEvent(user);
    }
}
