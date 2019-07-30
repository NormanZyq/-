package com.neuedu.project.controller;

import com.alibaba.fastjson.JSON;
import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.domain.Question;
import com.neuedu.project.domain.utils.QuestionUtils;
import com.neuedu.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目控制器。
 * 负责各种题目相关控制
 *
 * @author zyq
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    /**
     * 题目的service。
     */
    private final QuestionService questionService;

    /**
     * 强制注入
     *
     * @param questionService 题目的service
     */
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * 添加单个问题。
     * 要求前端按照Java类中的字段名称传入数据
     *
     * @param question 题目对象
     * @param response response，用于设置状态码
     * @return 成功或失败
     */
    @PostMapping("/add/single")
    @ResponseBody
    public String add(@RequestParam Question question,
                      HttpServletResponse response) {
        int type = question.getQuestionType();
        if (type == 0) {
            questionService.addChoiceQuestion(question);
            response.setStatus(MyHttpStatus.OK.value());
            return "成功添加一道题";
        } else {
            questionService.addSubjectiveQuestion(question);
            response.setStatus(MyHttpStatus.FAIL.value());
            return "添加失败，请重试";
        }
    }

    /**
     * 添加多道题，前端传入各个数据的数组，（按照顺序）。
     *
     * @param courseId          考试ID数组
     * @param questionType      问题类型数组
     * @param questionContent   考试内容数组
     * @param choicesStrings    选项字符串数组
     * @param rightAnswerString 正确答案数组
     * @param resources         资源数组
     * @return 成功的详细数据，或者抛出异常结束
     */
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

    /**
     * 根据课程ID获得选择题。
     *
     * @param id 课程ID
     * @return 题目的json字符串
     */
    @GetMapping(value = "/get/cq/{id}")
    @ResponseBody
    public String getChoiceQuestionsByCourseId(@PathVariable int id) {
        return JSON.toJSONString(questionService.getChoiceQuestionByCourseId(id));
    }

    /**
     * 根据课程ID获得主观题。
     *
     * @param id 课程ID
     * @return 题目的json字符串
     */
    @GetMapping(value = "/get/sq/{id}")
    @ResponseBody
    public String getSubjectiveQuestionsByCourseId(@PathVariable int id) {
        return JSON.toJSONString(questionService.getSubjectiveQuestionByCourseId(id));
    }

}













