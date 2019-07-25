package com.neuedu.project.config;

import com.neuedu.project.interceptor.LoginInInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置拦截器的配置信息
@Configuration
public class LoginInInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //服务器请求拦截器起作用
        String[] interceptor = {"/student", "/teacher",
                "/admin", "/*.html"};
//        String[] interceptor = {"/hello"};

        LoginInInterceptor loginInInterceptor = new LoginInInterceptor();

        InterceptorRegistration registration = registry.addInterceptor(loginInInterceptor);

        registration.addPathPatterns(interceptor);
        registration.excludePathPatterns("/login.html");

    }
}
