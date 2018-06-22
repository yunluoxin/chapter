package com.dadong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by dadong on 2018/6/22.
 */
@Configuration
@Import({DaoConfig.class, BConfig.class})
public class CConfig {

}
