package com.neuedu.project.dao;

import com.neuedu.project.domain.Course;
import com.neuedu.project.domain.Student;
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
     * 将老师添加到授课列表的dao层，提供新教师的ID和课程ID完成添加。
     *
     * @param teacherId 教师ID
     * @param courseId  课程ID
     */
    void addTeacherToCourse(@Param("teacherId") String teacherId,
                            @Param("courseId") int courseId);

    /**
     * 学生选课，提供学生ID和课程ID完成选课。
     *
     * @param studentId 学生学号
     * @param courseId  课程ID
     */
    void addStudentToCourse(@Param("studentId") String studentId,
                             @Param("courseId") int courseId);

    /**
     * 获取学生选的课程。
     *
     * @param studentId 学号
     * @return 学生所选的课程列表
     */
    List<Course> queryStudentSelectedCourse(String studentId);
    /**
     * 获取选择这一课的学生
     *
     * @param courseId 课程ID
     * @return 选择课程的学生集合
     */
    List<String> getStudentIdFromCourse(int courseId);


}
