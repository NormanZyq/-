package com.neuedu.project.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面控制器，负责各种页面应设为.html。
 *
 * @author zyq
 */
@Controller
public class PageController {

    /**
     * 跳转到考试页面，需要拦截器判断学生是否拥有这个考试。
     *
     * @param request request
     * @param id      考试ID
     * @return 考试页面
     */
    @GetMapping(value = "/exam/{id}")
    public String exam(HttpServletRequest request, @PathVariable int id) {
        request.setAttribute("testId", id);
        return "redirect:/exam.html?testId=" + id;
    }

    /**
     * 跳转到自己的页面。
     * 学生进入学生页面
     * 教师进入教师页面
     *
     * @return 返回学生页面，通过拦截器转向正确页面
     */
    @GetMapping(value = "/mypage")
    public String hhh() {
        return "/student";
    }

    /**
     * 主页 
     *
     * @return 主页
     */
    @GetMapping({"/", "/index"})
    public String index() {
        return "/head.html";
    }

    /**
     * 学生页面。
     *
     * @return 学生页面
     */
    @GetMapping(value = "/student")
    public String studentPage() {
        return "/student.html";
    }

    /**
     * 教师页面。
     *
     * @return 教师页面
     */
    @GetMapping(value = "/teacher")
    public String teacherPage() {
        return "/teacher.html";
    }

    /**
     * 管理员。
     *
     * @return 管理员
     */
    @GetMapping(value = "/admin")
    public String admin() {
        return "/admin.html";
    }

    /**
     * 登录。
     *
     * @return 登录
     */
    @GetMapping(value = "/login")
    public String login() {
        return "/login.html";
    }

    /**
     * 注册。
     *
     * @return 注册界面
     */
    @GetMapping(value = "/register")
    public String register() {
        return "/register.html";
    }

    /**
     * 测试用。
     *
     * @return hello
     */
    @GetMapping(value = "/hello")
    public String hello() {
        return "/hello.html";
    }

}
