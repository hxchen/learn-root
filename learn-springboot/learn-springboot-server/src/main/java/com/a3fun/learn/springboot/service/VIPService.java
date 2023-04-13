package com.a3fun.learn.springboot.service;

import com.a3fun.learn.springboot.exec.MainWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VIPService {
    private Logger LOGGER = LoggerFactory.getLogger(MainWorker.class);
    public void tick(long now){
        LOGGER.info(Thread.currentThread().getName() + "VIP Service tick 开始函数处理 vip 逻辑");
    }
}
