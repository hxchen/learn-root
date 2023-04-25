# 基于 Dubbo x Spring Boot 的微服务开发
├── learn-dubbo-api             // 共享 API 模块
├── learn-dubbo-consumer        // 消费端模块
└── learn-dubbo-provider        // 服务端模块

如上所示，共有三个模块，其中api模块被`consumer`和`provider`两个模块共同依赖，存储RPC通信使用的API接口。

# 共享API 模块
//API接口
learn-dubbo/learn-dubbo-api/src/main/java/com/a3fun/learn/dubbo/api/service/UserService.java

# 消费端模块
// 消费端启动类
learn-dubbo/learn-dubbo-consumer/src/main/java/com/a3fun/learn/dubbo/consumer/ConsumerApplication.java 
// 消费端SpringBoot配置文件
learn-dubbo/learn-dubbo-consumer/src/main/resources/application.yml

# 服务端模块
// 服务端实现类
learn-dubbo/learn-dubbo-provider/src/main/java/com/a3fun/learn/dubbo/provider/service/impl/UserServiceImpl.java
// 服务端启动类
learn-dubbo/learn-dubbo-provider/src/main/java/com/a3fun/learn/dubbo/provider/ProviderApplication.java

1. 启动ZooKeeper
2. 运行ProviderApplication
3. 运行ConsumerApplication