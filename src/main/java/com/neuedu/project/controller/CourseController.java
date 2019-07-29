package com.neuedu.project.controller;

import com.alibaba.fastjson.JSON;
import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.Course;
import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.domain.User;
import com.neuedu.project.service.CourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 所有课程相关的接口。
 *
 * @author zyq
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    private Logger log = Logger.getLogger(CourseController.class);

    /**
     * course service for course controller.
     */
    @Autowired
    private CourseService courseService;

    /**
     * add a course, and then put the requesting teacher to the teaching list.
     *
     * @param courseName course name
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String addCourse(String courseName, HttpSession session) {
        Object obj = session.getAttribute("loggedUser");
        if (obj == null) {
            return null;
        } else {
            courseService.addCourse(((User) obj).getUserId(), courseName);
            return "成功添加课程";
        }
    }

    /**
     * add teacher to teaching list.
     *
     * @param teacherId teacher id
     * @param courseId  course id: which course you want to add teacher
     */
    @PostMapping(value = "/addTeacher")
    @ResponseBody
    public void addTeacherToCourse(String teacherId, int courseId) {
        courseService.addTeacherToCourse(teacherId, courseId);
    }

    /**
     * student select a course.
     *
     * @param courseId which course the student is selecting.
     * @param session  http servlet session
     * @param response http servlet response
     */
    @PostMapping(value = "/selectCourse")
    @ResponseBody
    public void studentSelectCourse(int courseId,
                                    HttpSession session,
                                    HttpServletResponse response) {
        Object obj = session.getAttribute("loggedUser");
        if (obj != null) {
            User user = (User) obj;
            String id = user.getUserId();
            courseService.addStudentToCourse(id, courseId);
            response.setStatus(MyHttpStatus.OK.value());
        } else {
            response.setStatus(MyHttpStatus.FAIL.value());
        }

    }

    /**
     * get courses by their name, for searching fucntins.
     * （用作搜索功能的实现）
     *
     * @param name name you are searching
     * @return  a list that courses' names are all name @param name
     */
    @GetMapping(value = "/get/{name}")
    @ResponseBody
    public String getCoursesByName(@PathVariable String name) {
        List<Course> courseByName = courseService.getCourseByName(name);
        log.info(courseByName);
        return JSON.toJSONString(courseByName);
    }

    /**
     * get the loggged in user's all courses.
     *
     * todo
     *
     * 学生获得他们所选课程
     * 老师获得他们所教课程
     *
     * @param session   session
     * @return  选课列表或授课列白哦
     */
    @GetMapping(value = "/get/my")
    @ResponseBody
    public List<Course> getAll(HttpSession session) {
        Object obj = session.getAttribute("loggedUser");
        if (obj == null) {
            return null;
        } else {
            User user = (User) obj;

            int identity = (int) session.getAttribute("loggedIdentity");

            String id = user.getUserId();

            if (identity == 0) {
                // 获得学生所选课程
                log.info("学生请求获取所选课程");
                return courseService.getStudentCourse(id);
            } else {
                // 获得教师所教课程
                assert identity == 1;
                // todo
                log.info("教师请求获取所教课程");
                return null;
            }
        }
    }

}
