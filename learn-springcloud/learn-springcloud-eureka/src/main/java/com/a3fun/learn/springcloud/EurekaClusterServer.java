package com.a3fun.learn.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author haixiangchen
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaClusterServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterServer.class, args);
    }
}
