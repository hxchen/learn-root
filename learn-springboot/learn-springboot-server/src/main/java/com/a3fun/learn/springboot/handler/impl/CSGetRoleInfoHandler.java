package com.a3fun.learn.springboot.handler.impl;

import com.a3fun.learn.sb.protocol.CSGetRoleInfo;
import com.a3fun.learn.springboot.handler.CsAbstractMessageHandler;
import com.a3fun.learn.springboot.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class CSGetRoleInfoHandler extends CsAbstractMessageHandler<CSGetRoleInfo> {
    private static Logger LOGGER = LoggerFactory.getLogger(CSGetRoleInfoHandler.class);
    @Override
    protected void handle(Role role, CSGetRoleInfo message) {
        LOGGER.info("获取角色信息：" + role + message);
    }
}
