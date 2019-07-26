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

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    //    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get/login")
    @ResponseBody
    public User getLoginUser(HttpServletRequest request) {
        // todo 需要拦截器，判断是否已登录
        return (User) request.getSession().getAttribute("loggedUser");
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(String userId, String password,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        User user = new User();

        if (userId == null || "".equals(userId.trim())
                || password == null || "".equals(password.trim())) {
            response.setStatus(MyHttpStatus.EMPTY.value());
            return "用户名和密码不能为空";
        }
        // 设置用户名密码供数据库的查询
        user.setUserId(userId);
        user.setPassword(password);

        if (userService.login(user)) {
            User loggedIn = userService.getUser(userId, password);
            // 标记为成功登录
            request.getSession().setAttribute("loggedUser", loggedIn);

            //设置身份，判断用户是学生(0)还是老师(1)，或者管理员(2)
            //request.getSession().setAttribute("loggedIdentity",0);
            String allowPage = "/login";
            switch (loggedIn.getIdentity()) {
                case 0:
                    allowPage = "/student";
                    break;
                case 1:
                    allowPage = "/teacher";
                    break;
                case 2:
                    allowPage = "/admin";
                    break;
            }
            request.getSession().setAttribute("allowPage", allowPage);
            request.getSession().setAttribute("loggedIdentity",loggedIn.getIdentity());
            response.setStatus(MyHttpStatus.OK.value());
            // 设置密码并返回前端
            loggedIn.setPassword(password);
            return JSON.toJSONString(loggedIn);
        }
        response.setStatus(MyHttpStatus.FAIL.value());
        return "用户名和密码不匹配";
    }

    @PostMapping(value = "/register")
    public String resister(String userId, String password,
                           String name, int identity,
                           HttpServletResponse response) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return "../success.html";
//        System.out.println("In");
//        userService.register(userId, password, name, identity);
    }



}
















