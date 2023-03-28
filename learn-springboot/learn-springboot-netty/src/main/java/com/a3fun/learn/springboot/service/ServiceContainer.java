package com.a3fun.learn.springboot.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ServiceContainer {

    @Autowired
    VIPService vipService;

}
