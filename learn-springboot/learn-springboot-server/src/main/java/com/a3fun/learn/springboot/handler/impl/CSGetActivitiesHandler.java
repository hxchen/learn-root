package com.a3fun.learn.springboot.handler.impl;

import com.a3fun.learn.sb.protocol.CSGetActivities;
import com.a3fun.learn.springboot.handler.CsAbstractMessageHandler;
import com.a3fun.learn.springboot.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class CSGetActivitiesHandler extends CsAbstractMessageHandler<CSGetActivities> {
    private static Logger LOGGER = LoggerFactory.getLogger(CSGetActivitiesHandler.class);
    @Override
    protected void handle(Role role, CSGetActivities message) {
        LOGGER.info("获取活动：" + role + message);
    }
}
