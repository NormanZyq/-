package com.neuedu.project.config;

import com.neuedu.project.interceptor.ExamAccessInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ExamControlConfig implements WebMvcConfigurer {

    /**
     * logger.
     */
    private final Logger log = Logger.getLogger(ExamControlConfig.class);

    private final String[] examControl = {"/exam", "/exam.html"};

    @Bean
    public ExamAccessInterceptor getAccessInterceptor() {
        log.info("--- 注入 ExamInterceptor ---");
        return new ExamAccessInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAccessInterceptor()).addPathPatterns(examControl);
    }
}
