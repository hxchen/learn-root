package com.a3fun.learn.clients.tasks;

import com.a3fun.learn.clients.Client;

import java.io.UnsupportedEncodingException;

public class SendTask implements Runnable{
    Client client;
    String content;

    int times;

    public SendTask(Client client, String content, int times){
        this.client = client;
        this.content = content;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                client.sendData(client.name + " 第" + i + "次发送数据 ->"+content);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
