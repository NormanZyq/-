package com.neuedu.project.service;

import com.neuedu.project.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {


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
        return null;
    }

    @Override
    public List<Question> getSubjectiveQuestionByCourseId(int courseId) {
        return null;
    }
}
