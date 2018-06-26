package com.dadong.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by dadong on 2018/6/26.
 */
@Component
@Aspect
public class TestAspecj {
	@Before(value = "execution(* com.dadong.*.service..*.insert*(..))")
	public void test(JoinPoint joinPoint){
		System.out.println("执行了insert操作");
	}
}
