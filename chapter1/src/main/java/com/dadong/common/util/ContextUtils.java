package com.dadong.common.util;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created by Xiaodong on 2018/6/30.
 * 几个上下文 获取工具
 */
public class ContextUtils {
    public static ServletContext getServletContext(){
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext() ;
        ServletContext servletContext = context.getServletContext() ;
        return servletContext ;
    }
    public static WebApplicationContext getWebApplicationContext(){
        return ContextLoader.getCurrentWebApplicationContext() ;
    }
}
