package com.neuedu.project.controller;

import com.neuedu.project.domain.Question;
import com.neuedu.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/singleAdd")
    @ResponseBody
    public String add(@RequestParam Question question,
                      HttpServletResponse response) {
        int type = question.getQuestionType();
        if (type == 0) {
            questionService.addChoiceQuestion(question);
            return "success";
        } else {
            questionService.addSubjectiveQuestion(question);
            return "failed";
        }
    }

    public String add() {

//        String extract = "[\"']:\\s*[^\"']"
        return "";
    }




}













