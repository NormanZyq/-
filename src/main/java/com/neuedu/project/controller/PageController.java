package com.neuedu.project.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping(value = "/student")
    public String studentPage() {
        // todo 需要拦截器
        return "student.html";
    }

    @GetMapping(value = "/teacher")
    public String teacherPage() {
        // todo 需要拦截器
        return "teacher.html";
    }

    @GetMapping(value = "/admin")
    public String admin() {
        return "admin.html";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login.html";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register.html";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello.html";
    }

}
