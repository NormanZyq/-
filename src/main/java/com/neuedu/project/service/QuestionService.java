package com.neuedu.project.service;

import com.neuedu.project.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    /**
     * add a choice question.
     * @param question a choice question
     */
    void addChoiceQuestion(Question question);

    /**
     * add a subjective question.
     * @param subjectiveQuestion subjective question
     */
    void addSubjectiveQuestion(Question subjectiveQuestion);

    /**
     * fetch all questions whose course is the course with id: courseId
     * @param courseId  course id
     * @return  a list contains all questions in this course of courseId
     */
    List<Question> getAllQuestionsByCourseId(int courseId);

    List<Question> getChoiceQuestionByCourseId(int courseId);

    List<Question> getSubjectiveQuestionByCourseId(int courseId);

}
