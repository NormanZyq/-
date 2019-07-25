package com.neuedu.project.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(LoginInInterceptor.class);

    private String forwardPage = "/login";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        // 获取session
        HttpSession session = request.getSession();

        // 获得登录角色标记
        Object obj = session.getAttribute("loggedIdentity");

        // 获得允许访问的页面
        String allowPage = (String) session.getAttribute("allowPage");
        // todo 上面可以不需要这个页面，现场对loggedIdentity做一个switch即可

        // 获得当前正尝试访问的路径
        String visitingPage = request.getRequestURI();

        // 判断是否登录
        if (obj != null) {
            // 成功登录，判断身份
            // 如果此二者相等，允许访问
            boolean allow = visitingPage.equals(allowPage)
                    || visitingPage.equals(allowPage + ".html");
            if (allow) {
                // 允许访问
                return true;
            } else {
                // 访问错误，不允许，重定向到允许的页面
                response.sendRedirect(allowPage);
                return false;
            }
        } else {
            // 未登录，跳转到登陆界面
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }

//
//        //成功跳转,按角色分配页面
//        switch (identity) {
//            case 0:
//                forwardPage = "/student";
//                break;
//            case 1:
//                forwardPage = "/teacher";
//                break;
//            case 2:
//                forwardPage = "/admin";
//                break;
//            //ToDo
//            /*default:
//                return false;*/
//        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
