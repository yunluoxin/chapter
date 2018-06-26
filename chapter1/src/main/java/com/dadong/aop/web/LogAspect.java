package com.dadong.aop.web;

import com.dadong.common.util.ServletUtils;
import com.dadong.user.domain.LoginLog;
import com.dadong.user.domain.User;
import com.dadong.user.service.LoginLogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by dadong on 2018/6/23.
 */
@Component
@Aspect
public class LogAspect {
	@Autowired
	private LoginLogService loginLogService ;

	@AfterReturning(value = "execution(* com.dadong.user.controller..*.loginCheck(..))", returning = "mv")
	public void log(JoinPoint joinPoint, ModelAndView mv){
		if (mv.getModel().get("error") == null){
			// 登录成功
			System.out.println("------------log---------------") ;
			User user = (User) ServletUtils.getSession().getAttribute("user") ;
			LoginLog loginLog = new LoginLog() ;
			loginLog.setUserId(user.getUserId()) ;
			loginLog.setLoginDate(new Date());
			loginLog.setIp(ServletUtils.getRequest().getRemoteAddr());
			this.loginLogService.insert(loginLog) ;
		}
	}
}
