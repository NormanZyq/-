package com.neuedu.project.controller;

import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.service.ArrangeService;
import com.neuedu.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private ArrangeService arrangeService;

    @PostMapping(value = "/autoCreate/{id}")
    @ResponseBody
    public String autoCreateByCourseId(@PathVariable int id,
                                       int cqCount,
                                       int sqCount,
                                       HttpServletResponse response) {

        //Test for Temporary
        testService.autoCreateTest(id, cqCount, sqCount);
        response.setStatus(MyHttpStatus.OK.value());
        return "ok";
    }


    @PostMapping(value = "/arrange")
    @ResponseBody
    public String arrangeTest(int testId, String startTime, int duration) {

        //Test for Temporary
        arrangeService.arrangeTest(testId,startTime,duration);
        return "ok";
    }

    @PostMapping(value = "/get/tests")
    @ResponseBody
    public List<Arrangement> getArrangedTestsByStudentId(HttpSession httpSession) {
        String studentId = (String)httpSession.getAttribute("loggedId");
        return testService.getArrangedTestsByStudentId(studentId);
    }
}


