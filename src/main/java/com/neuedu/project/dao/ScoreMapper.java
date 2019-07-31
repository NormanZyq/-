package com.neuedu.project.dao;

import com.neuedu.project.domain.Score;
import org.apache.ibatis.annotations.Mapper;

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
}
