package com.dadong.user.dao.impl;

import com.dadong.user.domain.LoginLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadong on 2018/6/21.
 */
@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate ;

	@Autowired
	private NamedParameterJdbcTemplate template ;

	public void insertLoginLog(LoginLog loginLog){
		final String sql = "insert into t_login_log (user_id, ip, login_date) " +
				"values (?, ?, ?) ";
		Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()} ;
		jdbcTemplate.update(sql, args) ;
	}

	public List<LoginLog> selectLogsByUserId(final Integer userId) {
		final String sql = "select * from t_login_log where user_id = :userId" ;
		final List<LoginLog> list = new ArrayList<LoginLog>() ;
		template.query(sql, new MapSqlParameterSource().addValue("userId", userId), new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				LoginLog loginLog = new LoginLog() ;
				loginLog.setIp(resultSet.getString("ip"));
				loginLog.setLoginDate(resultSet.getDate("login_date"));
				loginLog.setUserId(userId);
				loginLog.setLoginLogId(resultSet.getInt("login_log_id"));
				list.add(loginLog) ;
			}
		});
		return list ;
	}
}
