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
 * 这个controller主要负责和学生相关的请求处理，所有url都要有/student
 *
 * @author zyq
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    /**
     * student service.
     */
    private final StudentService studentService;

    /**
     * force injection.
     *
     * @param studentService student service
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 为学生注册（分配）。
     *
     * @param userId   学号
     * @param password 密码
     * @param name     名称
     * @return todo 待定
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public String register(String userId,
                           String password,
                           String name) {
        studentService.registerStudent(userId, password, name);
        return "";
    }


}
