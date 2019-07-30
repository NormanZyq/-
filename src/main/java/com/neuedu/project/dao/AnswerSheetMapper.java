package com.neuedu.project.dao;

import com.neuedu.project.domain.AnswerSheet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerSheetMapper {
    /**
     * 添加一份作答到数据库.
     * @param answerSheet   答题卡
     */
    void insertAnswers(AnswerSheet answerSheet);


}
