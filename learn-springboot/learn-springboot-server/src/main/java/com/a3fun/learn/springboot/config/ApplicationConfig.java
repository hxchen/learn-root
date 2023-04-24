package com.a3fun.learn.springboot.config;

import com.a3fun.learn.springboot.handler.factory.ArraySpringMessageHandlerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    ArraySpringMessageHandlerFactory arraySpringMessageHandlerFactory(){
        return new ArraySpringMessageHandlerFactory();
    }

}
