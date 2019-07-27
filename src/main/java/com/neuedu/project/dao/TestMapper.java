package com.neuedu.project.dao;

import com.neuedu.project.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {


    /**
     * 教师创建课程.
     *
     * @param test 新的课程对象.
     *
     */
    void addTest(Test test);

    /**
     * 学生方面：获取学生的考试信息
     *
     * @param studentId 学生id
     * @return
     */
    List<Test> getStudentTests(String studentId);

    /**
     * 基本查询功能，有testId获取整个test信息
     *
     * @param tId testId
     * @return test_id为testId的test表
     */
    Test queryTest(int tId);


}
