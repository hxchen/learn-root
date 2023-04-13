package com.a3fun.learn;

import com.a3fun.learn.clients.Client;
import com.a3fun.learn.clients.tasks.ConnectTask;
import com.a3fun.learn.clients.MyIgnorePolicy;
import com.a3fun.learn.clients.NameTreadFactory;
import com.a3fun.learn.clients.tasks.SendTask;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Hello world!
 */
@Slf4j
public class ClientMain {

    public static void main(String[] args) throws InterruptedException {
        //1. 准备线程池
        int corePoolSize = 2;
        int maximumPoolSize = 8;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10000);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        executor.prestartAllCoreThreads(); // 预启动所有核心线程
        //2. 准备建立连接
        List<Client> clientList = new ArrayList<>();
        String IP = "127.0.0.1";
        int port = 9000;
        int TASK_COUNT = 2000;
        CountDownLatch latch = new CountDownLatch(TASK_COUNT);
        for (int i = 0; i < TASK_COUNT; i++) {
            Client client = new Client("client - " + i, IP, port, latch);
            clientList.add(client);
            ConnectTask task = new ConnectTask(client);
            executor.execute(task);
        }
        latch.await();
        log.info("所有链接已准备就绪，发送数据");
        //3. 发送数据
        for (int i = 0; i < clientList.size(); i++) {
            SendTask sendTask = new SendTask(clientList.get(i), "hello, world", 3);
            executor.submit(sendTask);
        }

    }
}
