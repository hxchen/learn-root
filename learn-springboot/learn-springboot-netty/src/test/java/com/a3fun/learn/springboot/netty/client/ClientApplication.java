package com.a3fun.learn.springboot.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ClientApplication {
    private static ChannelFuture future;
    static class Player implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Player(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            Bootstrap bootstrap = new Bootstrap();
            NioEventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                bootstrap.group(workerGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
                bootstrap.handler(new GameServerClientInitializer());
                //连接
                System.out.format("%s wait\n", name);
                cyclicBarrier.await();
                future = bootstrap.connect("127.0.0.1", 9000).sync();
                System.out.format("%s:客户端[%s]-服务器[127.0.0.1:9000]链接已建立!\n", new Date().getTime(), name);
                sendData(name.getBytes(CharsetUtil.UTF_8));
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        private void sendData(byte[] bytes) {
            System.out.format("%s:发送数据：%s\n", new Date().getTime(), new String(bytes));
            future.channel().writeAndFlush(Unpooled.copiedBuffer(bytes));
        }
    }
    static class Race {
        int player = 200;
        public Race(){}
        private CyclicBarrier cyclicBarrier = new CyclicBarrier(player);

        public void start() {
            List<Player> athleteList = new ArrayList<>();
//            athleteList.add(new Player(cyclicBarrier, "博尔特"));
//            athleteList.add(new Player(cyclicBarrier, "鲍威尔"));
//            athleteList.add(new Player(cyclicBarrier, "盖伊"));
//            athleteList.add(new Player(cyclicBarrier, "布雷克"));
//            athleteList.add(new Player(cyclicBarrier, "加特林"));
//            athleteList.add(new Player(cyclicBarrier, "苏炳添"));
//            athleteList.add(new Player(cyclicBarrier, "路人甲"));
//            athleteList.add(new Player(cyclicBarrier, "路人乙"));
            for (int i = 0; i < player; i++){
                athleteList.add(new Player(cyclicBarrier, "player_" + i));
            }
            Executor executor = Executors.newCachedThreadPool();
            for (Player player : athleteList) {
                executor.execute(player);
            }
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }
}
