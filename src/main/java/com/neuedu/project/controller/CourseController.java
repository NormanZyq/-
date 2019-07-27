package com.neuedu.project.controller;

import com.neuedu.project.domain.Course;
import com.neuedu.project.domain.MyHttpStatus;
import com.neuedu.project.domain.User;
import com.neuedu.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/add")
    @ResponseBody
    public void addCourse(String teacherId, String courseName) {
        courseService.addCourse(teacherId, courseName);
    }

    @PostMapping(value = "/addTeacher")
    @ResponseBody
    public void addTeacherToCourse(String teacherId, int courseId) {
        courseService.addTeacherToCourse(teacherId, courseId);
    }

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

    @GetMapping(value = "/get/{name}")
    public List<Course> getCoursesByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }

    @GetMapping(value = "/get/my")
    @ResponseBody
    public List<Course> getAll(HttpSession session) {
        Object obj = session.getAttribute("loggedUser");
        if (obj == null) {
            return null;
        } else {
            User user = (User) obj;

            int identity = (int) session.getAttribute("loggedIdentity");

            if (identity == 0) {
                // 获得学生所选课程

            } else {
                // 获得教师所教课程

            }

            String id = user.getUserId();

            return courseService.getStudentCourse(id);
        }

    }


}
