package com.neuedu.project.controller;

import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.domain.Question;
import com.neuedu.project.domain.Test;
import com.neuedu.project.domain.utils.QuestionUtils;
import com.neuedu.project.service.ArrangeService;
import com.neuedu.project.service.QuestionService;
import com.neuedu.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * service for test.
     */
    @Autowired
    private TestService testService;

    /**
     * service for arrangement.
     */
    @Autowired
    private ArrangeService arrangeService;

    /**
     * service fo question.
     */
    @Autowired
    private QuestionService questionService;

    /**
     * auto create a test with passed in number of 客观题和主观题.
     *
     * @param id       课程ID
     * @param cqCount  选择题数量
     * @param sqCount  主观题数量
     * @param response response用于设置状态码
     * @return 成功题书
     */
    @PostMapping(value = "/autoCreate/{id}")
    @ResponseBody
    public String autoCreateByCourseId(@PathVariable int id,
                                       int cqCount,
                                       int sqCount,
                                       HttpServletResponse response) {

        //Test for Temporary
        testService.autoCreateTest(id, cqCount, sqCount);
        response.setStatus(MyHttpStatus.OK.value());
        return "创建考试成功，确认无误后即可发布";
    }

    /**
     * 发布一场考试。
     *
     * @param testId    考试ID
     * @param startTime 开始时间
     * @param duration  时长
     * @return 成功提示
     */
    @PostMapping(value = "/arrange")
    @ResponseBody
    public String arrangeTest(int testId, String startTime, int duration) {

        //Test for Temporary
        arrangeService.arrangeTest(testId, startTime, duration);
        return "发布考试成功，请通知学生按时参加考试";
    }

    /**
     * 获得已登录学生所有的考试安排。
     *
     * @param httpSession session用于获取学号
     * @return 所有考试安排
     */
    @PostMapping(value = "/get/all")
    @ResponseBody
    public List<Arrangement> getArrangedTestsByStudentId(HttpSession httpSession) {
        String studentId = (String) httpSession.getAttribute("loggedId");
        return testService.getArrangedTestsByStudentId(studentId);
    }

    /**
     * 参与考试。
     *
     * @param id 考试ID
     * @return  考试页面
     */
    @PostMapping(value = "/attend")
    public String attendTest(int id) {
        // 学生加入考试
        return "/exam.html";
    }

    /**
     * 获得选择题。
     *
     * @param testId 考试ID
     * @return 选择题列表
     */
    @PostMapping(value = "/get/xuanze")
    @ResponseBody
    public List<ChoiceQuestion> getXuanZeTi(int testId) {
        Test test = testService.getTestById(testId);
        String cqIds = test.getChoiceQuestionIds();

        if (cqIds != null && !"".equals(cqIds.trim())) {
            // 解析选择题
            List<Question> forChoiceQuestions = new ArrayList<>();
            for (String idString : cqIds.split("\\s+")) {
                int id = Integer.parseInt(idString);
                Question question = questionService.getQuestionById(id);
                forChoiceQuestions.add(question);
            }
            List<ChoiceQuestion> choiceQuestions = QuestionUtils.getInstance().parseAsChoiceQuestions(forChoiceQuestions);
            // 解析选择题完成
            return choiceQuestions;
        } else {
            return null;
        }

    }

    /**
     * 获得主观题。
     *
     * @param testId 考试ID
     * @return 主观题列表
     */
    @PostMapping(value = "/get/zhuguan")
    @ResponseBody
    public List<Question> getZhuguan(int testId) {
        Test test = testService.getTestById(testId);
        String sqIds = test.getSubjectiveQuestionIds();

        if (sqIds != null && !"".equals(sqIds.trim())) {
            // 解析主观题
            List<Question> subjectiveQuestions = new ArrayList<>();
            for (String idString : sqIds.split("\\s+")) {
                int id = Integer.parseInt(idString);
                subjectiveQuestions.add(questionService.getQuestionById(id));
            }
            return subjectiveQuestions;
        } else {
            return null;
        }
    }

    /**
     * 获得考试剩余时间。
     *
     * @param testId 考试ID
     */
    @GetMapping(value = "/get/time")
    @ResponseBody
    public void getTimeLast(int testId) {
        // todo
    }

    @PostMapping(value = "/answer/submit")
    public void submitAnswers() {

    }

    @PostMapping(value = "/answer/check")
    public void checkAnsers() {

    }

}


