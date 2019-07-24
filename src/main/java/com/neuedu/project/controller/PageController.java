package com.neuedu.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
