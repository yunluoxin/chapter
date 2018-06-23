package com.dadong.user.service;

import com.dadong.user.dao.impl.LoginLogDao;
import com.dadong.user.domain.LoginLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dadong on 2018/6/23.
 */
@Service
public class LoginLogService {

	@Autowired
	private LoginLogDao loginLogDao ;

	public boolean insert(LoginLog loginLog){
		this.loginLogDao.insertLoginLog(loginLog);
		return true ;
	}

	public List<LoginLog> fetchAllLogs(Integer userId){
		return this.loginLogDao.selectLogsByUserId(userId) ;
	}
}
