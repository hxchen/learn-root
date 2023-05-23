package com.a3fun.learn.springboot.service.impl;

import com.a3fun.learn.springboot.service.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PasswordValidator implements Validator {
    @Override
    public void validate(String email, String password, String name) {
        log.info("PasswordValidator:{},{},{}", email, password, name);
    }
}
