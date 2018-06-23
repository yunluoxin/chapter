package com.dadong.user.dao;

import com.dadong.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dadong on 2018/6/21.
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate ;

	public int getMatchCount(String userName, String password){
		final String sql = "select count(*) from t_user where user_name = ? and password = ?" ;
		return jdbcTemplate.queryForInt(sql,userName, password) ;
	}

	public User findUserByUserName(final String userName){
		final String sql = "select * from t_user where user_name = ? " ;
		final User user = new User() ;
		jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				user.setUserId(resultSet.getInt("user_id"));
				user.setUserName(userName);
				user.setLastIp(resultSet.getString("last_ip"));
				user.setLastVisit(resultSet.getDate("last_visit"));
			}
		});
		return user ;
	}

	public void updateLoginInfo(User user){
		final String sql = "update t_user set last_visit = ? ,last_ip = ? where user_id = ? " ;
		jdbcTemplate.update(sql, new Object[]{user.getLastVisit(), user.getLastIp(), user.getUserId()}) ;
	}
}
