package com.springaop.logging;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
//    @Before("execution(public  void com.springaop.service.UserService.logIn())")
//    public void loggingAdvice1(){
//        System.out.println("Before advice for login is executed");
//    }
//
//    @After("execution(public void com.springaop.service.UserService.logIn())")
//    public void loggingAdvice2(){
//        System.out.println("After advice for login is executed");
//    }

    @Around("execution(public void com.springaop.service.UserService.logIn())") //Around is combination of Before & After
    public void loggingAdvice3(){
        System.out.println("Around advice for login is executed");
    }

    @AfterThrowing("execution(public void com.springaop.service.UserService.logout())")
    public void loggingAdvice4() {
        System.out.println("Exception thrown in logOut method");
    }

    @AfterReturning("execution(public void com.springaop.service.UserService.logout())")
    public void loggingAdvice5() {
        System.out.println("AfterReturning advice for logOut is run");
    }

    @Pointcut("execution(public * com.springaop.service.UserService.*(..))")
    public void pointCut() {
    }
    @Pointcut("execution(public * com.springaop.service.UserService.*(..))")
    public void pointCut1() {
    }

    @Before("pointCut() || pointCut1()")
    public void loggingAdvice6() {
        System.out.println("Before advice using pointcut is executed");
    }

}
