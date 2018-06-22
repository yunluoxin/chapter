package com.dadong.config;

import com.dadong.model.B;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dadong on 2018/6/22.
 */
@Configuration
public class BConfig {

	@Bean(name = "moneyBean")
	public B b(){
		B b = new B() ;
		b.setTotalMoney(100d);
		b.setUsed(5d) ;
		b.setLetf(b.getTotalMoney() - b.getUsed());
		return b ;
	}
}
