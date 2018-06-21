package com.dadong.user.service;

import com.dadong.user.dao.LoginLogDao;
import com.dadong.user.dao.UserDao;
import com.dadong.user.domain.LoginLog;
import com.dadong.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dadong on 2018/6/21.
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao ;

	@Autowired
	private LoginLogDao loginLogDao ;

	public Boolean hasMatchUser(String userName, String password){
		int count = this.userDao.getMatchCount(userName, password) ;
		return count == 1 ;
	}

	public User findUserByUserName(String userName){
		return this.userDao.findUserByUserName(userName) ;
	}

	public void loginSuccess(User user){
		this.userDao.updateLoginInfo(user);
		LoginLog loginLog = new LoginLog() ;
		loginLog.setUserId(user.getUserId());
		loginLog.setLoginDate(user.getLastVisit());
		loginLog.setIp(user.getLastIp());
		this.loginLogDao.insertLoginLog(loginLog);
	}
}