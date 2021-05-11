package com.a3fun.learn.springboot.netty.client;

import com.a3fun.learn.springboot.netty.server.GameServerListener;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class ClientApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(ClientApplication.class);
    private static ChannelFuture future;

    public static void connect(){
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new GameServerClientInitializer());
            //连接
            future = bootstrap.connect("127.0.0.1", 9000).sync();
            LOGGER.info("客户端-服务器[127.0.0.1:9000]链接已建立!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void sendData(byte[] bytes) {
        future.channel().writeAndFlush(Unpooled.copiedBuffer(bytes));
    }
    public static void main(String[] args) {
        connect();

        System.out.println("请输入您发送的内容：");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            byte[] bytes = sc.next().getBytes();
            ClientApplication.sendData(bytes);
        }
    }
}
