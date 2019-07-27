package com.neuedu.project.controller;

import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(value = "/autoCreate/{id}")
    @ResponseBody
    public String autoCreateByCourseId(@PathVariable int id,
                                       int cqCount,
                                       int sqCount,
                                       int duration,
                                       HttpServletResponse response) {

        //Test for Temporary
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        testService.autoCreateTest(id, cqCount, sqCount, currentTime, duration);
        response.setStatus(MyHttpStatus.OK.value());
        return "ok";
    }


}
