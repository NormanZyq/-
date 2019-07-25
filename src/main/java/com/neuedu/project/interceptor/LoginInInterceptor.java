package com.neuedu.project.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(LoginInInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        //判断是否成功登录
        if (session.getAttribute("loggedIn") == null
                || session.getAttribute("loggedIdentity") == null) {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        boolean loggedIn = (boolean) session.getAttribute("loggedIn");
        if (!loggedIn) {
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        //成功跳转,按角色分配页面
        switch ((Integer) session.getAttribute("loggedIdentity")) {
            case 0:
                request.getRequestDispatcher("/student").forward(request, response);
                break;
            case 1:
                request.getRequestDispatcher("/teacher").forward(request, response);
                break;
            case 2:
                request.getRequestDispatcher("/admin").forward(request, response);
                break;
            //ToDo
            /*default:
                return false;*/
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
