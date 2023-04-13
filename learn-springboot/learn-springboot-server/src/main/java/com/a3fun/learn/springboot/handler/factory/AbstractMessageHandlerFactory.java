package com.a3fun.learn.springboot.handler.factory;

import com.a3fun.learn.springboot.handler.MessageHandler;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author haixiangchen
 */
public class AbstractMessageHandlerFactory implements MessageHandlerFactory{
    private static Logger LOGGER = LoggerFactory.getLogger(AbstractMessageHandlerFactory.class);
    @Override
    public <H extends MessageHandler<?, ?>> H getMessageHandler(int message) {
        return null;
    }

    public void init() {
        Reflections reflections = new Reflections();
        // 找到包下的所有类
        Set<Class<? extends MessageHandler>> handlerClazzes = reflections.getSubTypesOf(MessageHandler.class);
        Map<String, Class<? extends MessageHandler>> nameClazzMap = new HashMap<>();
        for (Class<? extends MessageHandler> clazz : handlerClazzes) {
            // 转成用SimpleName做key，方便查找
            nameClazzMap.put(clazz.getSimpleName(), clazz);
        }
        LOGGER.info("获取到的handler配置数目:" + nameClazzMap.size());
    }
}
