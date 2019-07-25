package com.neuedu.project.controller;

import com.alibaba.fastjson.JSON;
import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.Question;
import com.neuedu.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add/single")
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

    @PostMapping("/add/multiple")
    @ResponseBody
    public String multipleAdd(int[] courseId, int[] questionType, String[] questionContent,
                              String[] choicesStrings, String[] rightAnswerString,
                              String[] resources) {
        int length = courseId.length;
//        List<Question> choice = new ArrayList<>();
//        List<Question> subjective = new ArrayList<>();

        int choiceCount = 0;
        int subjectiveCount = 0;

        for (int i = 0; i < length; i++) {
            int currentType = questionType[i];
            Question question = new Question(courseId[i], questionType[i],
                    questionContent[i], choicesStrings[i], rightAnswerString[i],
                    resources[i]);
            if (currentType == 0) {
                // 选择题
//                choice.add(question);
                choiceCount++;
                questionService.addChoiceQuestion(question);
            } else if (currentType == 1) {
                // 主观题
//                subjective.add(question);
                subjectiveCount++;
                questionService.addSubjectiveQuestion(question);
            } else {
                throw new RuntimeException("题目类型存在错误，已中断添加");
            }
        }

        return String.format("添加成功！一共添加了%d道题，"
                        + "包括%d道客观题和%d道主观题。",
                length, choiceCount, subjectiveCount);
    }

    @GetMapping(value = "/get/cq/{id}")
    @ResponseBody
    public String getChoiceQuestionsByCourseId(@PathVariable int id) {
        return JSON.toJSONString(questionService.getChoiceQuestionByCourseId(id));
    }

    @GetMapping(value = "/get/sq/{id}")
    @ResponseBody
    public String getSubjectiveQuestionsByCourseId(@PathVariable int id) {
        return JSON.toJSONString(questionService.getSubjectiveQuestionByCourseId(id));
    }



}













