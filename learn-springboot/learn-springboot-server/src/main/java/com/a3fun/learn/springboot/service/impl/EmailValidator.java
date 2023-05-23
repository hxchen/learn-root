package com.a3fun.learn.springboot.service.impl;

import com.a3fun.learn.springboot.service.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class EmailValidator implements Validator {
    @PostConstruct
    public void init(){
        log.info("这里可以执行一些初始化工作");
    }
    @PreDestroy
    public void shutdown(){
        log.info("这里可以执行一些销毁前的工作");
    }
    @Override
    public void validate(String email, String password, String name) {
        log.info("EmailValidator:{},{},{}", email, password, name);
    }
}
