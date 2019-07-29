package com.neuedu.project.service;

import com.neuedu.project.dao.QuestionMapper;
import com.neuedu.project.dao.TestMapper;
import com.neuedu.project.domain.Question;
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
    public void autoCreateTest(int courseId, int cqCount, int sqCount, String currentTime, int duration) {
        Random random = new Random(System.currentTimeMillis());
        int num = Math.abs(random.nextInt());
        //新建Question做选择标准
        Question temp = new Question();
        temp.setCourseId(courseId);
        temp.setQuestionType(0);
        //选出选择题
        List<Question> cq = questionMapper.getQuestionsByCourseId(temp);
        temp.setQuestionType(1);
        //选出主观题
        List<Question> sq = questionMapper.getQuestionsByCourseId(temp);
        //如果题目过少，返回null
        if (cq.size() < cqCount || sq.size() < sqCount)
            testMapper.addTest(null);
        else {
            //运用随机函数实现随机生成题目
            Test test = new Test();
            //生成题目组id字符串
            String cIds = produceIds(cqCount, cq, num);
            String sIds = produceIds(sqCount, sq, num);
            test.setCourseId(courseId);
            test.setSubjectiveQuestionIds(sIds);
            test.setChoiceQuestionIds(cIds);
            test.setReleaseDate(currentTime);
            test.setDuration(duration);
            testMapper.addTest(test);
        }
    }

    @Override
    public List<Test> getArrangedTestsByCourseId() {
        // todo
        return null;
    }

    @Override
    public Test getTestById(int id) {
        return testMapper.queryTest(id);
    }

    private String produceIds(int sqCount, List<Question> sq, int num) {
        StringBuilder sIds = new StringBuilder();
        //避免选题数为0的情况,返回null
        if (sqCount == 0)
            return null;
        for (int i = 0; i < sqCount; i++) {
            int size = sq.size();//选择题库大小
            int choose = calcualteOJLD(size, num) - 1;//List下标减一
            if (i != 0)
                sIds.append(" ");
            sIds.append(sq.get(choose).getQuestionId());
            sq.remove(choose);
        }

        return sIds.toString();
    }

    //i为数组大小，j为顺次选择数
    private int calcualteOJLD(int i, int j) {
        if (i < j) {
            int sum = i;
            while (sum < j) {
                sum += i;
            }
            return i + j - sum;
        }
        return j;
    }
}
