package com.a3fun.learn.clients;

import com.a3fun.learn.netty.GameClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class Client {
    public String name;
    private String ip;
    private int port;

    private CountDownLatch latch;

    ChannelFuture channelFuture;

    public Client(String name, String ip, int port, CountDownLatch latch){
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.latch = latch;
    }

    /**
     * 建立连接
     */
    public void connect(){
        Bootstrap client = new Bootstrap();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(1);
        try {
            client.group(workerGroup);
            client.channel(NioSocketChannel.class);
            client.option(ChannelOption.SO_KEEPALIVE, true);
            client.handler(new GameClientInitializer());
            //连接
            channelFuture = client.connect(ip, port).sync();
            log.info(Thread.currentThread().getName() + ":客户端-服务器[" + ip +":9000]链接已建立!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            latch.countDown();
        }
    }

    public void sendData(String string) throws UnsupportedEncodingException {
        assert channelFuture != null;
        channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(string.getBytes("utf-8")));
        log.info("发送数据:" + string);
    }
}
