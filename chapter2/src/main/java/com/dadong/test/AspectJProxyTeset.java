package com.dadong.test;

import com.dadong.aop.PreGreetingAspect;
import com.dadong.model.NaiveWaiter;
import com.dadong.model.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class AspectJProxyTeset {
    public static void main(String args[]){
        Waiter target = new NaiveWaiter() ;

        AspectJProxyFactory proxyFactory = new AspectJProxyFactory() ;
        proxyFactory.setTarget(target) ;
        proxyFactory.addAspect(PreGreetingAspect.class) ;

        Waiter proxy = proxyFactory.getProxy() ;
        proxy.greetTo("John") ;
        proxy.serveTo("John") ;
    }
}
