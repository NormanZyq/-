package com.neuedu.project.service;

import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.Test;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考试相关service层.
 *
 * @author ljq
 */
@Service
public interface TestService {

    /**
     * 自动创建考试
     *
     * @param courseId 涉及课程id
     * @param cqCount  选择题数目
     * @param sqCount  主观题数目
     */
    void autoCreateTest(int courseId, int cqCount, int sqCount);

    /**
     * 删除考试。
     *
     * @param testId 试卷ID
     */
    void deleteTestById(int testId);

    /**
     * 学生界面：获得自己的考试信息
     */
    List<Arrangement> getArrangedTestsByStudentId(String studentId);

    /**
     * @param testId 考试id
     * @return 考试剩余时间, 未开始返回-1，已完成返回0
     */
    Long getTimeLast(int testId);

    Test getTestById(int id);

    /**
     * 查询信息存储为参数的考试参与信息表id.
     *
     * @param studentId 学生ID
     * @param testId    考试ID
     * @return 考试记录的ID
     */
    Integer getAttendTestRecId(String studentId, int testId);

    /**
     * 老师获取自己编写的考试。
     *
     * @param teacherId 工号
     * @return 考试列表
     */
    List<Test> getTestsByTeacherId(String teacherId);

    /**
     * 学生获取自己所有的考试
     *
     * @param studentId 学号
     * @return 考试列表
     */
    List<Test> getTestsByStudentId(String studentId);

//    int Calcualte_OJLD(int i, int j);

}
