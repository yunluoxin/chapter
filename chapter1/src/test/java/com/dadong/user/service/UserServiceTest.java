package com.dadong.user.service;

import com.dadong.user.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by dadong on 2018/6/21.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private UserService userService ;

	@Test
	public void hasMatchUser(){
		boolean b1 = this.userService.hasMatchUser("admin","123456") ;
		boolean b2 = this.userService.hasMatchUser("root","123456") ;
		assertTrue(b2);
		assertTrue(!b1);
	}

	@Test
	public void findUserByUserName(){
		User user = this.userService.findUserByUserName("root") ;
		assert user != null && (user.getUserName().equals("root")) ;
		System.out.print(user);
	}
}
