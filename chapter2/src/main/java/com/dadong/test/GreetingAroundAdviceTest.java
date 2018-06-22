package com.dadong.test;

import com.dadong.advice.GreetingInterceptor;
import com.dadong.model.NaiveWaiter;
import com.dadong.model.Waiter;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by dadong on 2018/6/22.
 * 环绕增强Demo
 */
public class GreetingAroundAdviceTest {
	public static void main(String args[]) {
		Waiter target = new NaiveWaiter() ;
		Advice advice = new GreetingInterceptor() ;
		ProxyFactory proxyFactory = new ProxyFactory() ;
		proxyFactory.setTarget(target) ;
		proxyFactory.addAdvice(advice) ;

		Waiter proxy = (Waiter)proxyFactory.getProxy() ;
		proxy.greetTo("dadong");
		proxy.serveTo("xiaodong");
	}
}
