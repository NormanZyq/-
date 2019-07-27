package com.neuedu.project.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TeacherAccess implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(TeacherAccess.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        Object obj = request.getSession().getAttribute("loggedIdentity");

        if (obj == null) {
            response.sendRedirect("/login");
            return false;
        } else {
            int identity = (int) obj;
            if (identity != 1) {
                logger.info("一个身份代号为 " + identity + " 的人正在访问教师页面，现在他被带走了...");
                response.sendRedirect((String) request.getSession().getAttribute("allowPage"));
                return false;
            }
        }
        return true;

    }
}
