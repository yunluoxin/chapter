package com.dadong.aop;

import com.dadong.user.dao.LoginLogDao;
import com.dadong.user.domain.LoginLog;
import com.dadong.user.domain.User;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dadong on 2018/6/23.
 */
@Component
@Aspect
public class LogAspect {
	@Autowired
	private LoginLogDao loginLogDao ;
	@Autowired
	private HttpSession session ;
	@Autowired
	private HttpServletRequest request ;

	@AfterReturning(value = "execution(* com.dadong.user.web..*.loginCheck(..))", returning = "mv")
	public void log(JoinPoint joinPoint, ModelAndView mv){
		if (mv.getModel().get("error") == null){
			// 登录成功
			System.out.println("------------log---------------") ;
			User user = (User)session.getAttribute("user") ;
			LoginLog loginLog = new LoginLog() ;
			loginLog.setUserId(user.getUserId()) ;
			loginLog.setLoginDate(new Date());
			loginLog.setIp(request.getRemoteAddr());
			this.loginLogDao.insertLoginLog(loginLog) ;
		}
	}
}
