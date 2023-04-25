package com.a3fun.learn.dubbo.consumer.task;

import com.a3fun.learn.dubbo.api.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task implements CommandLineRunner {
    // 通过 DubboReference 从 Dubbo 获取了一个 RPC 订阅
    @DubboReference
    private DemoService userService;
    @Override
    public void run(String... args) {
        System.out.println("开始任务——————————");
        String result = String.valueOf(userService.sayHello("John"));
        System.out.println("Receive result ======> " + result);

        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + userService.sayHello("John"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
