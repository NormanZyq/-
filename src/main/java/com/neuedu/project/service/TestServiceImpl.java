package com.neuedu.project.service;

import com.neuedu.project.dao.QuestionMapper;
import com.neuedu.project.dao.TestMapper;
import com.neuedu.project.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TestServiceImpl implements TestService {

    private final TestMapper testMapper;

    private final QuestionMapper questionMapper;

    @Autowired
    public TestServiceImpl(TestMapper testMapper, QuestionMapper questionMapper) {
        this.testMapper = testMapper;
        this.questionMapper = questionMapper;
    }

    @Override
    public void autoCreateTest(int courseId, int cqCount, int sqConut) {
        Random random = new Random(System.currentTimeMillis());

        int num = random.nextInt();

//        questionMapper.getQuestionsByCourseId()

    }

    @Override
    public List<Test> getArrangedTestsByCourseId() {
        // todo
        return null;
    }
}
