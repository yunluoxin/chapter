package com.dadong.user.service;

/**
 * Created by Xiaodong on 2018/6/30.
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//引入Spring配置
@ContextConfiguration({"classpath*:spring/applicationContext.xml","classpath*:spring/spring-mvc.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class BaseJUnitTest {
}
