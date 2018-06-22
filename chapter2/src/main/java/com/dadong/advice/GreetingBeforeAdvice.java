package com.dadong.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by dadong on 2018/6/22.
 * 前置增强Demo
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] objects, Object o) throws Throwable {
		System.out.println(o.getClass().getName() + "." + method.getName()) ;
		String name = (String)objects[0] ;
		System.out.println("How are you ! Mr." + name + ".");
//		System.out.println(o) ;
	}
}
