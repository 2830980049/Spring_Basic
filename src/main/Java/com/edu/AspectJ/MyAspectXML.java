package com.edu.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXML {
    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("XML前置通知 "+joinPoint);
    }
    //后置通知
    public void afterReturing(Object result){
        System.out.println("XML后置通知 "+result);
    }
    //环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("XML环绕前通知");
        Object obj = joinPoint.proceed();
        System.out.println("XML环绕后通知");
        return obj;
    }
    //异常抛出通知
    public void afterThrow(Throwable e){
        System.out.println("XML异常抛出通知"+e.getMessage());
    }
    //最终通知
    public void after(){
        System.out.println("XML最终通知");
    }

}
