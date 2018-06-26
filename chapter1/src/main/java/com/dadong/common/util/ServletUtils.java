package com.dadong.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dadong on 2018/6/26.
 */
public class ServletUtils {

	public static HttpSession getSession(){
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes() ;
		return attributes.getRequest().getSession() ;
	}

	public static HttpServletRequest getRequest(){
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes() ;
		return attributes.getRequest() ;
	}
//	public HttpResponse getResponse(){
//		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes() ;
//		return attributes.getRequest() ;
//	}
}
