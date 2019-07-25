package com.neuedu.project.controller;

import com.neuedu.project.domain.User;
import com.neuedu.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

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
                        HttpServletRequest request) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        if (userService.login(user)) {
            User loggedIn = userService.getUser(userId, password);
            // 标记为成功登录
            request.getSession().setAttribute("loggedUserId", userId);
            request.getSession().setAttribute("loggedUser", loggedIn);
            request.getSession().setAttribute("loggedIn", true);

            //设置身份，判断用户是学生(0)还是老师(1)，或者管理员(2)
            //request.getSession().setAttribute("loggedIdentity",0);
            request.getSession().setAttribute("loggedIdentity",loggedIn.getIdentity());
            return "ok";

        }
        return "does not exist";
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
















