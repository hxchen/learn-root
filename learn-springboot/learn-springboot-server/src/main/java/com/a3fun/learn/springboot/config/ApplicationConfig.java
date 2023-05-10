package com.a3fun.learn.springboot.config;

import com.a3fun.learn.springboot.handler.factory.ArraySpringMessageHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    ArraySpringMessageHandlerFactory arraySpringMessageHandlerFactory(){
        log.info("ArraySpringMessageHandlerFactory 初始化");
        return new ArraySpringMessageHandlerFactory();
    }

}
