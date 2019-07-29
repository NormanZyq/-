package com.neuedu.project.config;

import com.neuedu.project.interceptor.AdminAccess;
import com.neuedu.project.interceptor.StudentAccess;
import com.neuedu.project.interceptor.TeacherAccess;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置拦截器的配置信息

/**
 * 未登录时的拦截。
 * 登录前只允许访问少量页面，如主页、登录页面
 * 登录后才能访问学生、教师等的页面
 */
@Configuration
public class CharacterAccessConfig implements WebMvcConfigurer {

    private Logger logger = Logger.getLogger(CharacterAccessConfig.class);

    private final String[] teacherCanAccess = {"/teacher", "/course/add", "/course/addTeacher", "/teacher.html"};

    private final String[] studentCanAccess = {"/course/selectCourse", "/student", "/student.html", "/exam", "/exam.html"};

    private final String[] adminCanAccess = {"/admin", "/admin.html"};

    private final String[] exclude = {"/index", "/index.html", "/login", "/login.html"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TeacherAccess()).addPathPatterns(teacherCanAccess).excludePathPatterns(exclude);
        registry.addInterceptor(new StudentAccess()).addPathPatterns(studentCanAccess).excludePathPatterns(exclude);
        registry.addInterceptor(new AdminAccess()).addPathPatterns(adminCanAccess).excludePathPatterns(exclude);
    }
}
