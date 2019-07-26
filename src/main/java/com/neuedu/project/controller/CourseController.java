package com.neuedu.project.controller;

import com.neuedu.project.domain.Course;
import com.neuedu.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void studentSelectCourse(String studentId, int courseId) {
        courseService.addStudentToCourse(studentId, courseId);
    }

    @GetMapping(value = "/get/{name}")
    public List<Course> getCoursesByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }



}
