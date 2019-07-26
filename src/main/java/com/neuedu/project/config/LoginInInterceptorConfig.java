package com.neuedu.project.config;

import com.neuedu.project.interceptor.LoginInInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置拦截器的配置信息

/**
 * 未登录时的拦截。
 * 登录前只允许访问少量页面，如主页、登录页面
 * 登录后才能访问学生、教师等的页面
 */
@Configuration
public class LoginInInterceptorConfig implements WebMvcConfigurer {

    private Logger logger = Logger.getLogger(LoginInInterceptorConfig.class);

    private LoginInInterceptor loginInInterceptor = new LoginInInterceptor();

    private final String[] beforeLoginForbid = {"/student", "/teacher",
            "/admin", "/*.html"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //服务器请求拦截器起作用
//        String[] interceptor = {"/student", "/teacher",
//                "/admin", "/*.html"};
////        String[] interceptor = {"/hello"};
//
//        InterceptorRegistration registration = registry.addInterceptor(loginInInterceptor);
//
//        registration.addPathPatterns(beforeLoginForbid);
//
//        registration.excludePathPatterns("/login.html");
//        registration.excludePathPatterns("/hello.html");

    }

    public void addExclude(String page) {

    }
}
