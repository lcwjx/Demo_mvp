package com.app.lee.aop;

import com.app.lee.utils.LogUtils;
import com.app.lee.utils.ToastUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAnnoAspect {

    @Pointcut("execution(@com.app.lee.aop.CheckLogin * *(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint point) {
        System.out.println("@Before");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        LogUtils.e("@Around");
        if (true){
            ToastUtils.showShort("请登录");
        }
        joinPoint.proceed();

    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        LogUtils.e("@After");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint point, Object returnValue) {
        LogUtils.e("@AfterReturning");
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        LogUtils.e("@afterThrowing");
        LogUtils.e("ex = " + ex.getMessage());
    }

}
