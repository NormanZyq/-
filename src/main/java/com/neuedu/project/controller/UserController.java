package com.neuedu.project.controller;

import com.alibaba.fastjson.JSON;
import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.domain.User;
import com.neuedu.project.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.String.valueOf;

/**
 * 处理所有和user相关的请求。
 *
 * @author zyq
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * logger.
     */
    private Logger log = Logger.getLogger(valueOf(UserController.class));

    /**
     * 强制注入service.
     */
    private UserService userService;

    /**
     * 强制注入service.
     *
     * @param userService service
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取登录用户的信息.
     *
     * @param session session
     * @return todo 待定
     */
    @GetMapping(value = "/get/login")
    @ResponseBody
    public User getLoginUser(HttpSession session) {
        log.info("正在获取用户数据");
        return userService.getUserInfo((String) session.getAttribute("loggedId"));
    }

    /**
     * user login operation.
     *
     * @param userId   user id
     * @param password password
     * @param request  request
     * @param response response
     * @return the available page
     */
    @PostMapping(value = "/login")
    public String login(String userId, String password,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        User user = new User();

        if (userId == null || "".equals(userId.trim())
                || password == null || "".equals(password.trim())) {
            response.setStatus(MyHttpStatus.EMPTY.value());
            return null;
        }
        // 设置用户名密码供数据库的查询
        user.setUserId(userId);
        user.setPassword(password);

        if (userService.login(user)) {
            User loggedIn = userService.getUser(userId, password);
            log.info(loggedIn);

            //设置身份，判断用户是学生(0)还是老师(1)，或者管理员(2)
            //request.getSession().setAttribute("loggedIdentity",0);
            String pageAvailable;
            switch (loggedIn.getIdentity()) {
                case 0:
                    pageAvailable = "/student";
                    break;
                case 1:
                    pageAvailable = "/teacher";
                    break;
                case 2:
                    pageAvailable = "/admin";
                    break;
                default:
                    pageAvailable = "/login";
            }
            // 标记为成功登录
//            request.getSession().setAttribute("loggedUser", loggedIn);
            request.getSession().setAttribute("loggedId", userId);
            request.getSession().setAttribute("allowPage", pageAvailable);
            request.getSession().setAttribute("loggedIdentity", loggedIn.getIdentity());
            response.setStatus(MyHttpStatus.OK.value());

            log.info("User '" + loggedIn.getUserId() + "' logged in success. Redirecting to " + pageAvailable);
            return "redirect:" + pageAvailable;

        }
        response.setStatus(MyHttpStatus.FAIL.value());
        return null;
    }

    @PostMapping(value = "/register")
    public String resister(String userId, String password,
                           String name, int identity,
                           HttpServletResponse response) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return "../success.html";
//        userService.register(userId, password, name, identity);
    }


}
















