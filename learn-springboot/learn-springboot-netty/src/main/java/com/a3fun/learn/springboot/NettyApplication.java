package com.a3fun.learn.springboot;

import com.a3fun.learn.springboot.util.ApplicationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBootApplication 在 com.a3fun.learn.springboot 下面
 * Spring将自动扫描包com.a3fun.learn.springboot及其子包下的Bean
 * @author haixiangchen
 */
@SpringBootApplication
@ServletComponentScan
public class NettyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);

        ApplicationUtil.initRunTime();

        ApplicationUtil.initWorldScheduler();
    }
}
