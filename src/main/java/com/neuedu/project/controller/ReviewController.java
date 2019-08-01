package com.neuedu.project.controller;

import com.neuedu.project.domain.*;
import com.neuedu.project.domain.utils.QuestionUtils;
import com.neuedu.project.service.ArrangeService;
import com.neuedu.project.service.QuestionService;
import com.neuedu.project.service.ReviewService;
import com.neuedu.project.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final Logger log = Logger.getLogger(ReviewController.class);

    /**
     * service for test.
     */
    private final TestService testService;

    /**
     * service for arrangement.
     */
    private final ArrangeService arrangeService;

    /**
     * service fo question.
     */
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(TestService testService,
                            ArrangeService arrangeService,
                            ReviewService reviewService) {
        this.testService = testService;
        this.arrangeService = arrangeService;
        this.reviewService = reviewService;
    }

    /**
     * 添加学生评教信息（仅第一次）.
     *
     * @param session  session用于获取学号
     * @param courseId 课程Id
     * @param content  评教内容
     * @return 成功
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String addStudentReview(HttpSession session, int courseId, String content) {
        String studentId = (String) session.getAttribute("loggedId");
        reviewService.studentReviewStore(studentId, courseId, content);
        return "在线评教成功";
    }

    /**
     * 老师获取这一科评教信息.
     *
     * @param courseId 课程Id
     * @return 老师
     */
    @GetMapping(value = "/get/{courseId}")
    @ResponseBody
    public double[] TeacherReviewQuery(@PathVariable int courseId) {
        return reviewService.TeacherReviewQuery(courseId);
    }

    /**
     * 判断是否重复评教.
     *
     * @param session  session用于获取学号
     * @param courseId 课程Id
     * @return 重复评教->true,没有评教->false
     */
    @PostMapping(value = "/judge")
    @ResponseBody
    public boolean DuclipReview(HttpSession session, int courseId) {
        String studentId = (String) session.getAttribute("loggedId");
        return reviewService.DuclipReview(studentId, courseId);
    }


}


