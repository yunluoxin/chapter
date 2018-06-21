package com.dadong.user.dao;

import com.dadong.user.domain.LoginLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by dadong on 2018/6/21.
 */
@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate ;

	public void insertLoginLog(LoginLog loginLog){
		String sql = "insert into t_login_log (user_id, ip, login_date) " +
				"values (?, ?, ?) ";
		Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()} ;
		jdbcTemplate.update(sql, args) ;
	}
}
