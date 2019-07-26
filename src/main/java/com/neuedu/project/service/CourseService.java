package com.neuedu.project.service;

import com.neuedu.project.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    /**
     * 添加课程的service层，提供教师ID和课程名称完成创建。
     *
     * @param teacherId  教师ID
     * @param courseName 课程名称
     */
    void addCourse(String teacherId, String courseName);

    /**
     * 将老师添加到授课列表的service层，提供新教师的ID和课程ID完成添加。
     *
     * @param teacherId 教师ID
     * @param courseId  课程ID
     */
    void addTeacherToCourse(String teacherId, int courseId);

    /**
     * 学生选课，提供学生ID和课程ID完成选课。
     *
     * @param studentId 学生ID
     * @param courseId  课程ID
     */
    void addStudentToCourse(String studentId, int courseId);

    /**
     * 用课程名称查询所有的课程。
     *
     * @param courseName 课程名称
     * @return 名字是courseName的课程列表
     */
    List<Course> getCourseByName(String courseName);

}
