package com.neuedu.project.service;

import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.Student;
import com.neuedu.project.domain.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArrangeService {

    /**
     * 用于老师创建考试，自动把学习此学科的学生加入考试
     * 需要testid从test表中取出courseid，利用courseid取出选课学生id信息
     *
     * @param testId 考试id
     * @param startTime 考试开始时间
     * @param duration 考试持续时间
     */
    void arrangeTest(int testId, String startTime, int duration);

    Arrangement getTestArrangement(int testId);


}
