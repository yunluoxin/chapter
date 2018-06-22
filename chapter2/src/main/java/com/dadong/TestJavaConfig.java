package com.dadong;

import com.dadong.config.BConfig;
import com.dadong.config.CConfig;
import com.dadong.config.DaoConfig;
import com.dadong.model.A;
import com.dadong.model.B;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dadong on 2018/6/22.
 */
public class TestJavaConfig {
	public static void main(String args[]){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class) ;
		A a = (A)context.getBean("a") ;
		System.out.println(a);

		DaoConfig config = (DaoConfig)context.getBean("daoConfig") ;
		System.out.println(config);

		System.out.println("注册前");
		try{
			B b = (B)context.getBean("moneyBean") ;
			System.out.print(b);
		}catch (Exception e){
			System.out.println("抛出异常，不存在moneyBean这个Bean");
		}

		System.out.println("一次性注册多个");
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext() ;
		context2.register(DaoConfig.class);
		context2.register(BConfig.class);
		context2.refresh();
		B b1 = (B)context2.getBean("moneyBean") ;
		System.out.println(b1);

		System.out.println("用@import方法，导入");
		AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(CConfig.class) ;
		B b3 = (B)context3.getBean("moneyBean") ;
		System.out.println(b3);
	}
}
