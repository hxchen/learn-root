package com.a3fun.learn.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author haixiangchen
 */
@RestController
public class ConsumerController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String all() {
        // 发起REST请求
        return restTemplate.getForObject(getUrl("LEARN-SPRINGCLOUD-PRODUCER", "/hello"), String.class);
    }

    /**
     * 获取指定url
     * @param clientApplicationName 指定的服务提供名
     * @param interfaceName 需要消费的接口名
     * @return
     */
    private String getUrl(String clientApplicationName, String interfaceName) {
        // 使用loadBalancerClient的choose函数来负载均衡的选出一个eurekaClient的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose(clientApplicationName);
        // 获取之前eurekaClient /all接口地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + interfaceName;
        System.out.println(url);
        return url;
    }
}
