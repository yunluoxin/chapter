package com.dadong.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnObj, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself!") ;
    }
}
