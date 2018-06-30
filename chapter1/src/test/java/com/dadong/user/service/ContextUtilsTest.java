package com.dadong.user.service;

import com.dadong.common.util.ContextUtils;
import com.dadong.user.controller.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.ServletContext;

/**
 * Created by Xiaodong on 2018/6/30.
 */

public class ContextUtilsTest extends BaseJUnitTest{
    @Autowired
    private UserController controller ;

    @Test
    public void hah(){
        WebApplicationContext context = ContextUtils.getWebApplicationContext() ;
        System.out.println(context) ;
        System.out.println(this.controller.loginPage(null));
    }

    @Test
    public void eee(){
        ServletContext context = ContextUtils.getServletContext() ;
        System.out.println(context) ;
        context.setAttribute("name", "dadong") ;
        System.out.println(context.getAttribute("name")) ;
    }
}
