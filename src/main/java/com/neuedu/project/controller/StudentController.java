package com.neuedu.project.controller;

import com.neuedu.project.service.StudentService;
import com.neuedu.project.service.StudentServiceImpl;
import com.neuedu.project.service.UserService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个controller主要负责和学生相关的请求处理，所有url都要有/student.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/register")
    @ResponseBody
    public String register(String userId,
                           String password,
                           String name) {
        studentService.registerStudent(userId, password, name);
        return "";
    }







}
