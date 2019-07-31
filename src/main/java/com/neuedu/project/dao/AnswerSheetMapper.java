package com.neuedu.project.dao;

import com.neuedu.project.domain.AnswerSheet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerSheetMapper {
    /**
     * 添加一份作答到数据库.
     * @param answerSheet   答题卡
     */
    void insertAnswers(AnswerSheet answerSheet);

    /**
     * 获取这场考试所有学生的答题信息
     *
     * @param testid 考试id
     * @return 这场考试所有学生的答题信息
     */
    List<AnswerSheet> queryAnswerSheetAboutTest(int testid);

    /**
     * 用attendRecordId查询AnswerSheet
     *
     * @param attendRecordId 考试参与信息
     * @return 答题卡
     */
    AnswerSheet queryAnswerSheetByAttendRecordId(int attendRecordId);
}
