package com.neuedu.project.controller;

import com.neuedu.project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;



public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/???")
    @ResponseBody
    public void addAnswerSheet(HttpSession httpSession, int testId, String ca, String sa){
        String studentId = (String) httpSession.getAttribute("loggedId");
        answerService.addAnswerSheet(studentId,testId,ca,sa);
    }
}
