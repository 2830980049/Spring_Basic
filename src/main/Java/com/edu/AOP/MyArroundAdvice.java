package com.edu.AOP;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
public class MyArroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println();
        System.out.println("环绕前增强==========");
        //执行目标方法
        Object object = methodInvocation.proceed();
        System.out.println("环绕后增强==========");
        System.out.println();
        return object;
    }
}
