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
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);

        ApplicationUtil.initRunTime();

        ApplicationUtil.initWorldScheduler();

        ApplicationUtil.initHandler();

        regShutdownHook();
    }

    public static void regShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("优雅的关闭服务, 准备处理收尾工作");
                // do something
                System.out.println("可以安心停服了");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }, "Shutdown Server"));
    }
}
