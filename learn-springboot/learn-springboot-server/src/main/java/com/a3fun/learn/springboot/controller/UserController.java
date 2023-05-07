package com.a3fun.learn.springboot.controller;

import com.a3fun.learn.springboot.exec.UserTaskExecutors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haixiangchen
 */
@RestController
@Slf4j
public class UserController {
    @GetMapping(value = "/run")
    public String runAllTheTime(){
        UserTaskExecutors.executorService.execute(() -> {
            while (true){
                int i = 0;
                i++;
                if (i == Integer.MAX_VALUE){
                    log.info("线程结束执行：" + Thread.currentThread().getName() + ", i = " + i);
                    break;
                }
            }
        });
        return "run ok";
    }
}
