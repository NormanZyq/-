package com.neuedu.project.service;

import com.neuedu.project.dao.*;
import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.AttendTestRec;
import com.neuedu.project.domain.Student;
import com.neuedu.project.domain.Test;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangeServiceImpl implements ArrangeService {

    private final Logger log = Logger.getLogger(ArrangeServiceImpl.class);

    private final TestMapper testMapper;

    private final CourseMapper courseMapper;

    private final ArrangementMapper arrangementMapper;

    private final AttendTestRecMapper attendTestRecMapper;

    @Autowired
    public ArrangeServiceImpl(TestMapper testMapper, CourseMapper courseMapper,ArrangementMapper arrangementMapper,AttendTestRecMapper attendTestRecMapper) {
        this.testMapper = testMapper;
        this.courseMapper = courseMapper;
        this.arrangementMapper = arrangementMapper;
        this.attendTestRecMapper = attendTestRecMapper;
    }


    @Override
    public void arrangeTest(int testId, String startTime, int duration) {
        //获取试卷
        Test test = testMapper.queryTest(testId);
        //从试卷上取出课程id
        int courseId = test.getCourseId();
        //从课程中取出选课学生id集
        List<String> studentIds = courseMapper.getStudentIdFromCourse(courseId);
        //设置arrangement
        Arrangement arrangement = new Arrangement();
        arrangement.setTestId(testId);
        arrangement.setStartTime(startTime);
        arrangement.setDuration(duration);
        arrangementMapper.addArrangement(arrangement);
        //设置test_attend_records
        AttendTestRec  attendTestRec = new AttendTestRec();
        attendTestRec.setTestId(testId);
        for(String stuId: studentIds){
            attendTestRec.setStudentId(stuId);
            attendTestRecMapper.addAttendTestRec(attendTestRec);
        }
    }

    @Override
    public Arrangement getTestArrangement(int testId) {
        return arrangementMapper.getTestArrangement(testId);
    }
}
