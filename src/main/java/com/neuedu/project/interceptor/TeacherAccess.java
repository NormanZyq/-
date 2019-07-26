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
        } else if ((int) obj != 1) {
            response.sendRedirect((String) request.getSession().getAttribute("allowPage"));
            return false;
        }
        return true;

    }
}
