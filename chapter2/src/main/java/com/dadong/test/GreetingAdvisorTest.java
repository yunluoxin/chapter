package com.dadong.test;

import com.dadong.advice.GreetingBeforeAdvice;
import com.dadong.advisor.GreetingAdvisor;
import com.dadong.model.NaiveWaiter;
import com.dadong.model.Seller;
import com.dadong.model.Waiter;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class GreetingAdvisorTest {
    public static void main(String args[]) {
        Waiter waiter = new NaiveWaiter() ;
        GreetingAdvisor greetingadvisor = new GreetingAdvisor() ;
        Advice advice = new GreetingBeforeAdvice() ;
        greetingadvisor.setAdvice(advice);
        ProxyFactory proxyFactory = new ProxyFactory() ;
        proxyFactory.setTarget(waiter) ;
        proxyFactory.addAdvisor(greetingadvisor); ;

        Waiter proxy = (Waiter)proxyFactory.getProxy() ;
        proxy.greetTo("dadong");
        proxy.serveTo("xiaodong");


///////////////////////////////////////////////
        Seller seller = new Seller() ;
        ProxyFactory proxyFactory2 = new ProxyFactory() ;
        proxyFactory2.setTarget(seller) ;
        proxyFactory2.setProxyTargetClass(true);
        proxyFactory2.addAdvisor(greetingadvisor); ;

        Seller proxy2 = (Seller)proxyFactory2.getProxy() ;
        proxy2.greetTo("dadong");
        proxy2.serveTo("xiaodong");
    }
}
