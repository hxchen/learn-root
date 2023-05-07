package com.a3fun.learn.springboot.handler.factory;

import com.a3fun.learn.springboot.handler.MessageHandler;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author haixiangchen
 */
public abstract class AbstractMessageHandlerFactory implements MessageHandlerFactory{

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractMessageHandlerFactory.class);

    protected String handlerParentPackage = "com.a3fun.learn.springboot.handler.impl.";



    public void init() {
        Reflections reflections = new Reflections(this.handlerParentPackage);
        LOGGER.info("扫描包：" + this.handlerParentPackage);
        // 找到包下的所有类
        Set<Class<? extends MessageHandler>> handlerClazzes = reflections.getSubTypesOf(MessageHandler.class);
        Map<String, Class<? extends MessageHandler>> nameClazzMap = new HashMap<>();
        for (Class<? extends MessageHandler> clazz : handlerClazzes) {
            // 转成用SimpleName做key，方便查找
            nameClazzMap.put(clazz.getSimpleName(), clazz);
        }
        LOGGER.info("获取到的handler配置数目:{}", nameClazzMap.size());
        try {
            Class<?> clazz = Class.forName("com.a3fun.learn.sb.protocol.MessageType");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field: fields) {
                LOGGER.info("协议名：" + field.getName() + ", 值：" + field.getInt(clazz));
                if (field.getName().startsWith("SC")){
                    continue;
                }
                Class<? extends MessageHandler> handlerClazz = nameClazzMap.get(field.getName() + "Handler");
                if (handlerClazz == null){
                    LOGGER.error("消息{}没有定义消息处理器类", field.getName());
                }
                MessageHandler<?, ?> handler = getHandlerInstance(field.getInt(clazz), (Class<? extends MessageHandler<?, ?>>) handlerClazz);
                if (handler == null){
                    LOGGER.error("消息{}没有定义消息处理器", field.getName());
                }
                registerHandler(field.getInt(clazz), handler);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract MessageHandler<?, ?> getHandlerInstance(int messageId, Class<? extends MessageHandler<?, ?>> clazz);
    protected abstract void registerHandler(int messagedId, MessageHandler<?, ?> handler);
}
