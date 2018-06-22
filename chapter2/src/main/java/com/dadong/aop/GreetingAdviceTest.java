package com.dadong.aop;

import com.dadong.model.NaiveWaiter;
import com.dadong.model.Waiter;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by dadong on 2018/6/22.
 */
public class GreetingAdviceTest {
	public static void main(String args[]) {
		Waiter target = new NaiveWaiter() ;
		BeforeAdvice advice = new GreetingBeforeAdvice() ;
		ProxyFactory proxyFactory = new ProxyFactory() ;
		proxyFactory.setTarget(target) ;
		proxyFactory.addAdvice(advice) ;

		Waiter proxy = (Waiter)proxyFactory.getProxy() ;
		proxy.greetTo("dadong");
		proxy.serveTo("xiaodong");
	}
}
