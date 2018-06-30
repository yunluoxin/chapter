package com.dadong.aop.web;
import com.dadong.common.exception.BusinessException;
import com.dadong.common.vo.ApiResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dadong on 2018/6/30.
 */
@Component
@Aspect
@Order(5)
public class ControllerExceptionAspect {

	private static final String ERROR_MSG_KEY = "errorMsg" ; // 绑定到页面的错误消息key

	private static final String ERROR_PAGE_NAME = "error" ;  // 错误页面的名字

	@Around(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object globalControl(ProceedingJoinPoint pjd){
		try {
			return pjd.proceed();
		}catch (Throwable ex){
			MethodSignature methodSignature = (MethodSignature)pjd.getSignature() ;
			if (methodSignature.getMethod().getAnnotation(ResponseBody.class) != null){
				ApiResponse response = new ApiResponse() ;
				response.setSuccess(false) ;
				response.setErrorMsg(ex.getLocalizedMessage());
				// 业务异常
				if (ex instanceof BusinessException){
					response.setErrorCode(((BusinessException)ex).getErrorCode()) ;
				}else {
					ex.printStackTrace(); // 打印日志, 业务异常不需要记录
				}
				return response ;
			}else {
				ex.printStackTrace(); // 打印日志
				if (methodSignature.getReturnType() == ModelAndView.class){
					ModelAndView mv = new ModelAndView(ERROR_PAGE_NAME) ;
					mv.addObject(ERROR_MSG_KEY,ex.getLocalizedMessage()) ;
					return mv ;
				}else if (pjd.getArgs() != null){
					Object[] args = pjd.getArgs() ;
					for (Object arg : args){
						// 方法里绑定的Map, Model, 都会走这个。 org.springframework.validation.support.BindingAwareModelMap
						if (Map.class.isAssignableFrom(arg.getClass())){
							Map map = (Map)arg ;
							map.put(ERROR_MSG_KEY, ex.getLocalizedMessage()) ;
							break ;
						}else if (HttpServletRequest.class.isAssignableFrom(arg.getClass())){
							HttpServletRequest request = (HttpServletRequest)arg ;
							request.setAttribute(ERROR_MSG_KEY, ex.getLocalizedMessage());
							break ;
						}
						 // 对于在方法里绑定的ModelAndView，是没法真正绑定的，需要直接return ModelAndView类型的，这就回到了上一个可能
					}
				}
				return ERROR_PAGE_NAME ;
			}
		}
	}
}
