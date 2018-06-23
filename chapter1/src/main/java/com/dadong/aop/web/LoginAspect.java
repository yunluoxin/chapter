package com.dadong.aop.web;

import com.dadong.user.domain.User;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by dadong on 2018/6/23.
 */
@Component
@Aspect
public class LoginAspect {
	@Autowired
	private HttpSession session ;

	@Around("@annotation(com.dadong.aop.NeedLogin)")
	public Object process(ProceedingJoinPoint pjd) throws Throwable{
		User user = (User)session.getAttribute("user") ;
		if (user == null){
			System.out.println("需要登录，方法是 " + pjd.getTarget().getClass().getName() + " : " + pjd.getSignature().getName());
			return "login" ;
		}else {
			return pjd.proceed() ;
		}
	}
}
