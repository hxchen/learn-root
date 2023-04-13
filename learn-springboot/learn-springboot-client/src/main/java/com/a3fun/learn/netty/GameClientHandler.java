package com.a3fun.learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.nio.ByteBuffer;


/**
 * 客户端监听处理
 * 客户端继承 SimpleChannelInboundHandler
 * SimpleChannelInboundHandler在接收到数据后会自动release掉数据占用的ByteBuffer资源(自动调用ByteBuffer.release())
 *
 * @author haixiangchen
 */
@Component
public class GameClientHandler extends SimpleChannelInboundHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameClientHandler.class);

    /**
     * 通道数据读取
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        byte [] by = new byte [in.readableBytes()];
        in.readBytes(by);
        ByteBuffer buf = ByteBuffer.wrap(by);
        System.out.println("客户端收到的数据:" + buf);

    }
}
