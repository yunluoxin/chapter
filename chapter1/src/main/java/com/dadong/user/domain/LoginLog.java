package com.dadong.user.domain;

import java.util.Date;

/**
 * Created by dadong on 2018/6/21.
 */
public class LoginLog {
	private Integer loginLogId ;

	private Integer userId ;

	private String ip ;

	private Date loginDate ;

	public Integer getLoginLogId() {
		return loginLogId;
	}

	public void setLoginLogId(Integer loginLogId) {
		this.loginLogId = loginLogId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "LoginLog{" +
				"loginLogId=" + loginLogId +
				", userId=" + userId +
				", ip='" + ip + '\'' +
				", loginDate=" + loginDate +
				'}';
	}
}
