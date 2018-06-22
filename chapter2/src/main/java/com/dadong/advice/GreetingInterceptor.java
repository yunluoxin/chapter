package com.dadong.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments() ; // 获得目标方法的入参
        String clientName = (String)args[0] ;
        System.out.println("How are you! Mr." + clientName + ".") ;

        Object obj = methodInvocation.proceed() ; // 调用原来的方法

        System.out.println("Please enjoy yourself !")  ;
        return obj ;
    }
}
