package com.neuedu.project.dao;

import com.neuedu.project.domain.Question;

import java.util.List;

public interface QuestionMapper {

    void addChoiceQuestion(Question choiceQuestion);

    void addSubjectiveQuestion(Question subjectiveQuestion);

    List<Question> getQuestionsByCourseId(int courseId);


}
