package com.dadong.user.vo;

import javax.validation.constraints.Pattern;

/**
 * Created by dadong on 2018/6/21.
 */
public class LoginCommand {
	@Pattern(regexp = "\\w{4,20}",message = "用户名必须是大于4位数!")
	private String userName ;

	@Pattern(regexp = "\\w{6,20}",message = "密码必须是6-20位哦!")
	private String password ;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
