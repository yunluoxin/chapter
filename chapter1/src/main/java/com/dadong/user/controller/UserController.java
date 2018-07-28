package com.dadong.user.controller;

import com.dadong.aop.NeedLogin;
import com.dadong.common.util.ContextUtils;
import com.dadong.user.domain.User;
import com.dadong.user.service.LoginLogService;
import com.dadong.user.service.UserService;
import com.dadong.user.vo.LoginCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by dadong on 2018/6/21.
 */
@Controller
@RequestMapping(value = "/admin")
public class UserController {
	@Autowired
	private UserService userService ;

	@Autowired
	private LoginLogService loginLogService ;

	@RequestMapping(value = "/login.html")
	public String loginPage(Model model){
		return "login" ;
	}

	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, @Valid LoginCommand loginCommand, BindingResult bindingResult){
//		System.out.println(bindingResult.getFieldError().getDefaultMessage()); // 可以用来直接输出第一个错误!
		for (FieldError error : bindingResult.getFieldErrors()){
			System.out.println(error.getDefaultMessage());
		}
		boolean isVaildUser = this.userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword()) ;
		if (!isVaildUser){
			return new ModelAndView("login", "error","用户名或者密码错误") ;
		}else {
			User user = this.userService.findUserByUserName(loginCommand.getUserName()) ;
			user.setLastVisit(new Date());
			user.setLastIp(request.getRemoteAddr());
			this.userService.loginSuccess(user) ;
			request.getSession().setAttribute("user",user);
			return new ModelAndView("main") ;
		}
	}

	@RequestMapping(value = "/logs.html")
	@NeedLogin
	@ResponseBody
	public Object logs(HttpSession session){
		User user = (User)session.getAttribute("user") ;
		List list = this.loginLogService.fetchAllLogs(user.getUserId()) ;
		return list ;
	}
}
