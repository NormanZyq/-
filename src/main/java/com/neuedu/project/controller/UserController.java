package com.neuedu.project.controller;

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
        log.info("Using id: " + userId);
        log.info("Using password: " + password);

        if (userId == null || "".equals(userId.trim())
                || password == null || "".equals(password.trim())) {
            response.setStatus(MyHttpStatus.EMPTY.value());
            return "用户名和密码不能为空";
        }
        user.setUserId(userId);
        user.setPassword(password);
        if (userService.login(user)) {
            User loggedIn = userService.getUser(userId, password);
            // 标记为成功登录
//            request.getSession().setAttribute("loggedUserId", userId);
            request.getSession().setAttribute("loggedUser", loggedIn);
//            request.getSession().setAttribute("loggedIn", true);

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
            return "ok";
        }
        response.setStatus(MyHttpStatus.FAIL.value());
        return "用户不存在或密码不正确";
    }

    @PostMapping(value = "/register")
    public String resister(String userId, String password,
                           String name, int identity,
                           HttpServletResponse response) {
        System.out.println("In");
        userService.register(userId, password, name, identity);
        return "../success.html";
    }



}
















