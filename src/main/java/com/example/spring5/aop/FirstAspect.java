package com.example.spring5.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class FirstAspect {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer(){
    }

    @Pointcut("this(org.springframework.data.repository.Repository)")
    public void isRepository(){}

    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping(){}

    @Pointcut("args(org.springframework.ui.Model,..)")
    public void hasModelParam(){}

    @Pointcut("execution(public * com.example.spring5.jpa.user.UserService.userById(*))")
    public void anyFindByIdServiceMethod(){};

    @Before("anyFindByIdServiceMethod()")
    public void addLogging(JoinPoint joinPoint) {
        log.info("Logging advice: " + joinPoint.getTarget().getClass()
                + " method: "
                + joinPoint.getSignature().getName());
    }
}