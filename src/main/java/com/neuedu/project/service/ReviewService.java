package com.neuedu.project.service;

import org.springframework.stereotype.Service;

@Service
public interface ReviewService {

    /**
     * 存储评教信息，若有n个老师教同一门课，数据库里存储n条数据
     *
     * @param studentId 评教学生Id
     * @param courseId 评教课程Id
     */
    void studentReviewStore(String studentId, int courseId, String content);


    /**
     * 老师获取这门课的评教信息
     *
     * @param courseId 课程Id
     * @return 学生评教信息：具体数据取平均值存入数组
     */
    double[] TeacherReviewQuery(int courseId);

    /**
     * 判断是否多次评教
     *
     * @param studentId 学生Id
     * @return 是->true ,否->false
     */
    boolean DuclipReview(String studentId, int courseId);
}
