package com.neuedu.project.service;

import com.neuedu.project.dao.*;
import com.neuedu.project.domain.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    private final TestMapper testMapper;

    private final QuestionMapper questionMapper;

    private final AttendTestRecMapper attendTestRecMapper;

    private final ArrangementMapper arrangementMapper;

    private final CourseMapper courseMapper;

    /**
     * logger.
     */
    private final Logger log = Logger.getLogger(TestServiceImpl.class);

    @Autowired
    public TestServiceImpl(TestMapper testMapper, QuestionMapper questionMapper, AttendTestRecMapper attendTestRecMapper, ArrangementMapper arrangementMapper, CourseMapper courseMapper) {
        this.testMapper = testMapper;
        this.questionMapper = questionMapper;
        this.attendTestRecMapper = attendTestRecMapper;
        this.arrangementMapper = arrangementMapper;
        this.courseMapper = courseMapper;
    }

    @Override
    public void autoCreateTest(int courseId, int cqCount, int sqCount) {
        Random random = new Random(System.currentTimeMillis());
        int num = Math.abs(random.nextInt() % 10000);
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
            return;
        else {
            //运用随机函数实现随机生成题目
            Test test = new Test();
            //生成题目组id字符串
            String cIds = produceIds(cqCount, cq, num);
            String sIds = produceIds(sqCount, sq, num);
            test.setCourseId(courseId);
            test.setSubjectiveQuestionIds(sIds);
            test.setChoiceQuestionIds(cIds);
            testMapper.addTest(test);
        }
    }

    @Override
    public void deleteTestById(int testId) {
        testMapper.deleteTestByTestId(testId);
    }

    @Override
    public List<Arrangement> getArrangedTestsByStudentId(String studentId) {
        //获取学生的testIds
        List<Integer> testIds = attendTestRecMapper.getTestIdFromStudentId(studentId);
        //由testId获取考试安排信息
        List<Arrangement> arrangements = new ArrayList<>();
        for (int tId : testIds) {
            Arrangement arr = arrangementMapper.getTestArrangement(tId);
            //get courseId
            int cId = testMapper.queryTest(tId).getCourseId();
            //get courseName
            Course course = new Course();
            course.setCourseId(cId);
            String courseName = courseMapper.queryCourse(course).get(0).getCourseName();
            System.out.println(courseName);
            //添加状态信息
            long duration = arr.getDuration() * 60;
            long time = getTestTime(arr);
            //当前时间未开始考试
            if (time < 0)
                arr.setIdentity(-1);
            //当前时间已结束考试
            if (time >= duration)
                arr.setIdentity(0);
            else
                //当前考试正在进行
                arr.setIdentity(1);

            if (courseName != null) {
                arr.setCourseName(courseName);
                arrangements.add(arr);
            }
        }
        System.out.println(arrangements);
        return arrangements;
    }

    @Override
    public Long getTimeLast(int testId) {
        Arrangement arr = arrangementMapper.getTestArrangement(testId);
        if (arr == null) {
            return null;
        }
        long duration = arr.getDuration() * 60;
        long time = getTestTime(arr);
        //当前时间未开始考试
        if (time < 0)
            return (long) -1;
        //当前时间已结束考试
        if (time >= duration)
            return 0L;
        return duration - time;
    }

    @Override
    public Test getTestById(int id) {
        return testMapper.queryTest(id);
    }

    @Override
    public Integer getAttendTestRecId(String studentId, int testId) {
        return attendTestRecMapper.getAttendTestRecId(studentId, testId);
    }

    @Override
    public List<Test> getTestsByTeacherId(String teacherId) {
        return testMapper.getTeacherTests(teacherId);
    }

    @Override
    public List<Test> getTestsByStudentId(String studentId) {
        return null;
    }

    /**
     * autoCreateTest的辅助函数：已通过测试
     */
    private String produceIds(int sqCount, List<Question> sq, int num) {
        StringBuilder sIds = new StringBuilder();
        //避免选题数为0的情况,返回null
        if (sqCount == 0)
            return "";
        for (int i = 0; i < sqCount; i++) {
            int size = sq.size();//选择题库大小
            int choose = calculateOJLD(size, num) - 1;//List下标减一
            if (i != 0)
                sIds.append(" ");
            sIds.append(sq.get(choose).getQuestionId());
            sq.remove(choose);
        }

        return sIds.toString();
    }

    /**
     * autoCreateTest的辅助函数：已彻底测试
     */
    private int calculateOJLD(int i, int j) {
        //i为数组大小，j为顺次选择数
        if (i < j) {
            int sum = i;
            while (sum < j) {
                sum += i;
            }
            return i + j - sum;
        }
        return j;
    }

    /**
     * 考试状态信息的辅助函数:已测试
     *
     * @param arr 考试安排信息
     * @return 考试剩余时间
     */
    private long getTestTime(Arrangement arr) {
        String starttime = arr.getStartTime();
        //将开始时间转化为long类型,以秒为单位
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(starttime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long startsec = c.getTimeInMillis() / 1000;
        //将当前时间转化为龙类型,以秒为单位
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(currentTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long nowsec = c.getTimeInMillis() / 1000;
        return nowsec - startsec;
    }

    /**
     * From Internet
     * 字符串切割
     *
     */
    private List<String> analyseQuestionId(String questionIds){
        String[] temp = questionIds.split("#");
        List<String>  questions = new ArrayList<>();
        Collections.addAll(questions, temp);
        return questions;
    }
}
