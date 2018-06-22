package com.dadong.test;

import com.dadong.advice.TransactionManager;
import com.dadong.model.A;
import com.dadong.service.SimulateDB;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Xiaodong on 2018/6/22.
 * 抛出异常增强！！！ 测试不成功。。。。。。。。。
 */
public class TransactionManagerTest {
    public static void main(String args[]) throws Exception {
        SimulateDB simulateDB = new SimulateDB() ;
        Advice transactionManager = new TransactionManager() ;
        ProxyFactory factory = new ProxyFactory() ;
        factory.setTarget(simulateDB);
        factory.setProxyTargetClass(true);
        factory.addAdvice(transactionManager) ;

        SimulateDB proxy = (SimulateDB)factory.getProxy() ;
        proxy.insertOperate(new A());
        proxy.deleteOperate(5) ;

    }

}
