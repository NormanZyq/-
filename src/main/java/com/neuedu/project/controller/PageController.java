package com.neuedu.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping(value = "hello")
    public String hello() {
        return "hello.html";
    }

}
