package com.example.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer(){
    }

    @Pointcut("@within(com.example.spring5.jpa.*)")
    public void isServiceLayer(){
    }
    @Pointcut("this(org.springframework.data.repository.Repository)")
    public void isRepository(){}

    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping(){}

    @Pointcut("args(org.springframework.ui.Model,..)")
    public void hasModelParam(){}

    @Pointcut("execution(public * com.example.spring5.jpa.user.UserService.userById(*))")
    public void anyFindByIdServiceMethod(){};



}

