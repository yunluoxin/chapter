package com.dadong.user.service;

/**
 * Created by dadong on 2018/6/23.
 */

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {"/spring/applicationContext.xml"})
public abstract class BaseTestService extends AbstractTestNGSpringContextTests {
}
