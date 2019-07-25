package com.neuedu.project.service;

import com.neuedu.project.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    void addCourse(String teacherId, String courseName);

    void addTeacherToCourse(String teacherId, int courseId);

    void addStudentToCourse(String studentId, int courseId);

    List<Course> getCourseByName(String courseName);

}
