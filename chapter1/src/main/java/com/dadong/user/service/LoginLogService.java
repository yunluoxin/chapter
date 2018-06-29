package com.dadong.user.service;

import com.dadong.user.dao.impl.LoginLogDao;
import com.dadong.user.domain.LoginLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dadong on 2018/6/23.
 */
@Service
public class LoginLogService {

	@Autowired
	private LoginLogDao loginLogDao ;

	@Transactional
	public boolean insert(LoginLog loginLog){
		this.loginLogDao.insertLoginLog(loginLog);
//		throw new RuntimeException("fuck") ;
		return true ;
	}

	public List<LoginLog> fetchAllLogs(Integer userId){
		return this.loginLogDao.selectLogsByUserId(userId) ;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update(){
		LoginLog loginLog = new LoginLog() ;
		loginLog.setUserId(1) ;
		this.loginLogDao.updateLoginLog(loginLog) ;
	}
}
