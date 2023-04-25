package com.a3fun.learn.dubbo.provider.service.impl;

import com.a3fun.learn.dubbo.api.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "hello,"  + name;
    }

    @Override
    public String getAnswer(String q) {
        return "Nothing";
    }
}
