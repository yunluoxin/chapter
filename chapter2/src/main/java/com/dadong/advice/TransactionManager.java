package com.dadong.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class TransactionManager implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception e)throws Throwable{
        System.out.println("========") ;
        System.out.println("方法" + method.getName() + " 抛出异常：" + e.getMessage()) ;
        System.out.println("回滚事务") ;
    }

    public void afterThrowing(SQLException e)throws Throwable{
        System.out.println("========") ;
        System.out.println(" 抛出异常：" + e.getMessage()) ;
        System.out.println("回滚事务") ;
    }
}
