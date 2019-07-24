package com.neuedu.project.dao;

import com.neuedu.project.domain.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    void addChoiceQuestion(Question choiceQuestion);

    void addSubjectiveQuestion(Question subjectiveQuestion);

    List<Question> getQuestionsByCourseId(int courseId);


}
