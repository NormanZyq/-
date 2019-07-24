package com.neuedu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @PostMapping("/add")
    void add() {

    }

}
