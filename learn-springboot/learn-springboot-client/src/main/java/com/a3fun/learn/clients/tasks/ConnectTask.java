package com.a3fun.learn.clients.tasks;

import com.a3fun.learn.clients.Client;

public class ConnectTask implements Runnable{
    Client client;

    public ConnectTask(Client client){
        this.client = client;
    }

    @Override
    public void run() {
        client.connect();
    }
}
