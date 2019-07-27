package com.neuedu.project.dao;

import com.neuedu.project.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    /**
     * 新增试卷。
     * @param test 试卷对象
     */
    void addTest(Test test);

    /**
     * 用试卷ID删除试卷。
     * @param id 试卷ID
     */
    void deleteTestByTestId(int id);

    /**
     * 更新试卷。
     * @param forUpdate 用来更新的试卷对象
     */
    void updateTest(Test forUpdate);

    /**
     * 获得学生所有的考试。
     * @param studentId 学号
     * @return  考试列表
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
