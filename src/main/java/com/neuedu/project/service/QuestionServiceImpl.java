package com.neuedu.project.service;

import com.neuedu.project.dao.QuestionMapper;
import com.neuedu.project.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {


    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public void addChoiceQuestion(Question question) {

    }

    @Override
    public void addSubjectiveQuestion(Question subjectiveQuestion) {

    }

    @Override
    public List<Question> getAllQuestionsByCourseId(int courseId) {
        return null;
    }

    @Override
    public List<Question> getChoiceQuestionByCourseId(int courseId) {
        Question forQuery = new Question();
        forQuery.setCourseId(courseId);
        forQuery.setQuestionType(0);
        List<Question> questions = questionMapper.getQuestionsByCondition(forQuery);
        System.out.println(questions);

        return questions;
    }

    @Override
    public List<Question> getSubjectiveQuestionByCourseId(int courseId) {
        Question forQuery = new Question();
        forQuery.setCourseId(courseId);
        forQuery.setQuestionType(1);
        return questionMapper.getQuestionsByCondition(forQuery);
    }
}
