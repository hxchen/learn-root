package com.a3fun.learn.springboot.handler.impl;

import com.a3fun.learn.springboot.handler.CsAbstractMessageHandler;
import com.a3fun.learn.springboot.message.CsGetMails;
import com.a3fun.learn.springboot.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class CsGetMailsHandler extends CsAbstractMessageHandler<CsGetMails> {
    private static Logger LOGGER = LoggerFactory.getLogger(CsGetActivitiesHandler.class);
    @Override
    protected void handle(Role role, CsGetMails message) {
        LOGGER.info("获取邮件：" + role + message);
    }
}
