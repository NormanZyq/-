package com.neuedu.project.controller;

import com.neuedu.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
//    @ResponseBody
    public String login(String userId, String password,
                        HttpServletResponse response) {
        try {
            userService.login(userId, password);
        } catch (DataAccessException ex) {
            response.setStatus(500);
        }


        return "";
    }

}
