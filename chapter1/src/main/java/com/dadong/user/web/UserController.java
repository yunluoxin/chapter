package com.dadong.user.web;

import com.dadong.user.domain.User;
import com.dadong.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dadong on 2018/6/21.
 */
@Controller
@RequestMapping(value = "/admin")
public class UserController {
	@Autowired
	private UserService userService ;

	@RequestMapping(value = "/login.html")
	public String loginPage(){
		return "login" ;
	}

	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
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
}
