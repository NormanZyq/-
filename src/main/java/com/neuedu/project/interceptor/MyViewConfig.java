package com.neuedu.project.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyViewConfig extends WebMvcConfigurerAdapter {

    //配置虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Users/anothertask/Downloads/images").addResourceLocations("/images");
    }
}
