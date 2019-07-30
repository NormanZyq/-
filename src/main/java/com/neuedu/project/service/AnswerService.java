package com.neuedu.project.service;

import org.springframework.stereotype.Service;

@Service
public interface AnswerService {

    /**
     * 添加答题卡信息
     *
     * @param studentId 学生Id
     * @param testId 试卷Id
     * @param ca 选择题答案字符串
     * @param sa 主观题答案字符串
     */
    void addAnswerSheet(String studentId, int testId, String ca,String sa);
}
