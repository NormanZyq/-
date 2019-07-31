package com.neuedu.project.dao;

import com.neuedu.project.domain.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreMapper {

    /**
     * 插入学生成绩信息
     * @param score 学生成绩
     */
    void insertScore(Score score);

    /**
     *
     * @param answerRecordId 答题卡ID
     * @return 答题卡的得分信息
     */
    Score queryScoreByAnswerRecordId(int answerRecordId);

    /**
     * 获取排名信息
     *
     * @param studentId 学生ID
     * @param testId 考试Id
     * @return 包含学生成绩及rank的Score对象
     */
    List<Score> getRankByChoiceScore(@Param("testId") int testId);
}
