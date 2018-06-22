package com.dadong.advisor;

import com.dadong.model.NaiveWaiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    // 匹配方法
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().equals("greetTo");
    }
    // 匹配类
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return NaiveWaiter.class.isAssignableFrom(aClass);
            }
        } ;
    }

}
