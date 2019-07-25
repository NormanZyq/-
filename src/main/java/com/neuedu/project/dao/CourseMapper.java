package com.neuedu.project.dao;

import com.neuedu.project.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {

    /**
     * 教师创建课程.
     *
     * @param courseToAdd 新的课程对象，只需要courseName有值，执行完毕之后
     *                    courseId会被附上刚刚创建的课程ID以便其他操作
     */
    void addCourse(Course courseToAdd);

    /**
     * 根据传入的course对象中的属性获得所有满足要求的课程
     *
     * @param courseForQuery    仅用来查询的课程对象，没有现实意义
     * @return  满足条件的课程列表
     */
    List<Course> queryCourse(Course courseForQuery);

    /**
     * 将教师加入授课列表。
     *
     * @param teacherId 教师ID
     * @param courseId  课程ID
     */
    void addTeacherToCourse(@Param("teacherId") String teacherId,
                            @Param("courseId") int courseId);

    /**
     * 学生选课。
     *
     * @param studentId 学生学号
     * @param courseId  课程ID
     */
    void addStudentToCourse(@Param("studentId") String studentId,
                             @Param("courseId") int courseId);


}
