package com.a3fun.learn.springboot.tick;

import com.a3fun.learn.springboot.model.Activity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
public class ActivityTicker extends AbstractTicker<Activity> {

    @Override
    protected void tick(Activity activity, long now) {
        System.out.println("处理活动：" + activity);
    }

    @Override
    protected Collection<Activity> findAll() {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity(1L, "零元购1", 1677600000000L, 1680278399000L));
        list.add(new Activity(2L, "零元购2", 1677600000000L, 1680278399000L));
        list.add(new Activity(3L, "零元购3", 1677600000000L, 1680278399000L));
        return list;
    }
}
