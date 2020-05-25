package com.edu.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 */
@Aspect
public class MyAspectAnno {
    //前置通知 JoinPoint 用来获取切点信息
    @Before(value = "save()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知"+joinPoint);
    }

    @AfterReturning(value = "save()"
                    ,returning = "result")
    public void afterreturning(Object result){
        System.out.println("后置通知 "+result);
    }

    @Around(value = "execution(* com.edu.AspectJ.ProductsDao.update(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        //执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("环绕后通知");
        return obj;
    }

    @AfterThrowing(value = "find()",throwing = "e")
    public void afterthrowing(Throwable e){
        System.out.println("异常抛出通知 " + e);
    }

    @After(value = "execution(* com.edu.AspectJ.ProductsDao.find(..))")
    public void after(){
        System.out.println("最终通知");
    }

    @Pointcut(value = "execution(* com.edu.AspectJ.ProductsDao.save(..))")
    public void save(){}

    @Pointcut(value = "execution(* com.edu.AspectJ.ProductsDao.find(..))")
    public void find(){}
}
