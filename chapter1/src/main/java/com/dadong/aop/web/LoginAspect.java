package com.dadong.aop.web;

import com.dadong.common.vo.ApiResponse;
import com.dadong.user.domain.User;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

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
			System.out.println("需要登录，方法是 [" + pjd.getTarget().getClass().getName() + " ]. " + pjd.getSignature().getName());
			// 区分下是ajax访问，还是普通页面
			MethodSignature signature = (MethodSignature)pjd.getSignature() ;
			if (signature.getMethod().getAnnotation(ResponseBody.class) != null || pjd.getTarget().getClass().getAnnotation(ResponseBody.class) != null){
				ApiResponse response = new ApiResponse() ;
				response.setSuccess(false);
				response.setErrorCode(10000);
				response.setErrorMsg("您需要登录后才能访问哦！");
				return response ;
			}
			return "login" ;
		}else {
			return pjd.proceed() ;
		}
	}
}
