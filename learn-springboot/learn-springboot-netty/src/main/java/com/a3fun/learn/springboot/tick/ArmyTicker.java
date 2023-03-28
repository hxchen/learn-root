package com.a3fun.learn.springboot.tick;

import com.a3fun.learn.springboot.model.ArmyInfo;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
@Component
public class ArmyTicker extends AbstractTicker<ArmyInfo>{

    @Override
    protected void tick(ArmyInfo armyInfo, long now) {
        System.out.println("侦测每一位行军：" + armyInfo);
    }

    @Override
    protected Collection<ArmyInfo> findAll() {
        return Arrays.asList(new ArmyInfo(1L, 1001L), new ArmyInfo(2L, 10001L));
    }
}
