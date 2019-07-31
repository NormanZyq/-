package com.neuedu.project.controller;

import com.neuedu.project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 答案相关的控制器.
 *
 * @author ljq
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/add")
    @ResponseBody
    public String addAnswerSheet(HttpSession session, int testId, String ca, String sa) {
        String studentId = (String) session.getAttribute("loggedId");
        answerService.addAnswerSheet(studentId, testId, ca, sa);
        return "交卷成功！";
    }

    @PostMapping(value = "/????")
    @ResponseBody
    public void scoreChoiceQuestion(HttpSession httpSession, int testId) {
        String studentId = (String) httpSession.getAttribute("loggedId");
        answerService.scoreChoiceQuestion(studentId, testId);
    }

    @PostMapping(value = "/?????")
    @ResponseBody
    public Integer getChoiceScore(HttpSession httpSession, int testId) {
        String studentId = (String) httpSession.getAttribute("loggedId");
        return answerService.getChoiceScore(studentId, testId);
    }
}
