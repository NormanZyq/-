package com.neuedu.project.service;


import com.neuedu.project.dao.CourseMapper;
import com.neuedu.project.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }


    @Override
    public void addCourse(String teacherId, String courseName) {
        // 创建课程
        Course newCourse = new Course();
        newCourse.setCourseName(courseName);
        courseMapper.addCourse(newCourse);

        // 将执行创建课程的教师加入授课关系表
        courseMapper.addTeacherToCourse(teacherId, newCourse.getCourseId());
    }

    @Override
    public void addTeacherToCourse(String teacherId, int courseId) {
        courseMapper.addTeacherToCourse(teacherId, courseId);
    }

    @Override
    public void addStudentToCourse(String studentId, int courseId) {
        courseMapper.addStudentToCourse(studentId, courseId);
    }

    @Override
    public List<Course> getCourseByName(String courseName) {
        Course course = new Course();
        course.setCourseName(courseName);
        return courseMapper.queryCourse(course);
    }

    @Override
    public List<Course> getStudentCourse(String studentId) {
        return courseMapper.queryStudentSelectedCourse(studentId);
    }
}
