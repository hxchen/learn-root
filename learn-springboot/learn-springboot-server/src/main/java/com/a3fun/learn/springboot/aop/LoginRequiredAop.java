package com.a3fun.learn.springboot.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
public class LoginRequiredAop {

    //    @Pointcut("execution(* com.a3fun.learn.springboot.controller..*.*(..))")
    @Pointcut("@annotation(com.a3fun.learn.springboot.annonation.LoginRequired)")
    public void pointcut() {

    }


    @Around("pointcut()")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().getName() + " ==> 进入登录检查");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String name = request.getParameter("name");
        if ("zh".equals(name)){
            log.info("登录成功, 继续之前方法的执行");
            return joinPoint.proceed();
        }else {
            log.info("登录失败");
            return "登录失败";
        }
    }
}
