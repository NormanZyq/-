package com.neuedu.project.controller;

import com.neuedu.project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/add")
    @ResponseBody
    public void addAnswerSheet(HttpSession session, int testId, String ca, String sa){
        String studentId = (String) session.getAttribute("loggedId");
        answerService.addAnswerSheet(studentId,testId,ca,sa);
    }
}
