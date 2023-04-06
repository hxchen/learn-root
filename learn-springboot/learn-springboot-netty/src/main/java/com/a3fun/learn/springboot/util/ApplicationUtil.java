package com.a3fun.learn.springboot.util;

import com.a3fun.learn.springboot.exec.SingleThreadTaskWorker;
import com.a3fun.learn.springboot.handler.factory.ArraySpringMessageHandlerFactory;
import com.a3fun.learn.springboot.service.WorldService;
import com.a3fun.learn.springboot.world.WorldScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ApplicationUtil implements ApplicationContextAware {
    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationUtil.class);
    private static ApplicationContext applicationContext;

    private static WorldScheduler worldScheduler;

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        ApplicationUtil.applicationContext = applicationContext;
    }

    public static <T> Map<String, T> getBeanOfType(Class<T> t){
        return applicationContext.getBeansOfType(t);
    }
    /**
     *通过name获取 Bean.
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    /**
     * 通过Class获取Bean
     * @param requiredType
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> requiredType) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(requiredType);
    }
    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 主动向Spring容器中注册bean
     * @param name               BeanName
     * @param clazz              注册的bean的类性
     * @param args               构造方法的必要参数，顺序和类型要求和clazz中定义的一致
     * @param <T>
     * @return 返回注册到容器中的bean对象
     */
    public static <T> T registerBean(String name, Class<T> clazz,
                                     Object... args) {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        if(context.containsBean(name)) {
            Object bean = context.getBean(name);
            if (bean.getClass().isAssignableFrom(clazz)) {
                return (T) bean;
            } else {
                throw new RuntimeException("BeanName 重复 " + name);
            }
        }


        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        for (Object arg : args) {
            beanDefinitionBuilder.addConstructorArgValue(arg);
        }
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();

        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) context.getBeanFactory();
        beanFactory.registerBeanDefinition(name, beanDefinition);
        return applicationContext.getBean(name, clazz);
    }
    public static void initRunTime(){
        WorldService worldService = (WorldService) getBean("worldService");
        worldService.init();
    }

    public static void initWorldScheduler(){
        LOGGER.info(Thread.currentThread().getName() + "   initWorldScheduler");
        worldScheduler = new WorldScheduler();
        worldScheduler.start();
    }

    public static void initHandler(){
        ArraySpringMessageHandlerFactory factory = new ArraySpringMessageHandlerFactory();
        factory.init();
    }
}
