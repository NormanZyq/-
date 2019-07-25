package com.neuedu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

//    public String get

    @PostMapping(value = "/autoCreate/{id}")
    @ResponseBody
    public String autoCreateByCourseId(@PathVariable int id) {
        return "";
    }

}
