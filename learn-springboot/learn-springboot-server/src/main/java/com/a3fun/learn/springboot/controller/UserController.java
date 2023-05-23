package com.a3fun.learn.springboot.controller;

import com.a3fun.learn.springboot.exec.UserTaskExecutors;
import com.a3fun.learn.springboot.model.Player;
import com.a3fun.learn.springboot.service.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haixiangchen
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * Spring会把所有实现自动注入进来
     */
    @Autowired
    List<Validator> validators;
    /**
     * 一个故意写错的方法，让CPU 100%
     * @return
     */
    @GetMapping(value = "/run")
    public String runAllTheTime(){
        UserTaskExecutors.executorService.execute(() -> {
            while (true){
                int i = 0;
                i++;
                if (i == Integer.MAX_VALUE){
                    log.info("线程结束执行：" + Thread.currentThread().getName() + ", i = " + i);
                    break;
                }
            }
        });
        return "run ok";
    }

    @ResponseBody
    @GetMapping(value = "/redis-test")
    public String redisTest(){
        ValueOperations ops = redisTemplate.opsForValue();
        Player player = new Player(1, "zz" + 1, 1);
        ops.set("player1", player);
        System.out.println(redisTemplate.getValueSerializer());
        System.out.println(redisTemplate.getKeySerializer());
        Player result = (Player) redisTemplate.opsForValue().get("player1");
        return result.toString();
    }

    /**
     * 测试插入大量对象
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/redis-test-list")
    public long redisTestList(){
        long start = System.currentTimeMillis();

        ListOperations ops = redisTemplate.opsForList();
        for (int i = 0; i < 80000; i++){
            Player player = new Player(i, "zz" + i, i);
            ops.rightPushAll("players", player);
        }
        long time = System.currentTimeMillis() - start;
        return time;
    }

    /**
     * 测试在大量对象中查找效率
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/find-player")
    public long findPlayerById(long id){
        long start = System.currentTimeMillis();
        List<Player> playerList = redisTemplate.opsForList().range("players", 0, -1);
        for (Player player:playerList){
            if(player.getId() == id){
                log.info("查找到{}", player);
                break;
            }
        }
        long time = System.currentTimeMillis() - start;
        return time;
    }

    @ResponseBody
    @GetMapping(value = "/validator")
    public String validator(@RequestParam String email, @RequestParam String password, @RequestParam String name){
        for (Validator validator : validators){
            validator.validate(email, password, name);
        }
        return "success";
    }

}
