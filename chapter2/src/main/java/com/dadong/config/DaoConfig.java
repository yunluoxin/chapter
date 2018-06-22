package com.dadong.config;

import com.dadong.model.A;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dadong on 2018/6/22.
 */
@Configuration
public class DaoConfig {
	@Bean
	public A a(){
		A a = new A() ;
		a.setName("dadong");
		a.setAge(28);
		return a ;
	}
}
