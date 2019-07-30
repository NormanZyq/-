package com.neuedu.project.service;

import com.neuedu.project.dao.AnswerSheetMapper;
import com.neuedu.project.dao.AttendTestRecMapper;
import com.neuedu.project.domain.AnswerSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AttendTestRecMapper attendTestRecMapper;

    private final AnswerSheetMapper answerSheetMapper;

    @Autowired
    public AnswerServiceImpl(AttendTestRecMapper attendTestRecMapper,AnswerSheetMapper answerSheetMapper){
        this.attendTestRecMapper = attendTestRecMapper;
        this.answerSheetMapper = answerSheetMapper;
    }


    public void addAnswerSheet(String studentId, int testId, String ca,String sa){
        int attendTestRecId = attendTestRecMapper.getAttendTestRecId(studentId,testId);
        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setAttendRecordId(attendTestRecId);
        answerSheet.setChoiceQuestionAnswer(ca);
        answerSheet.setSubjectiveQuestionAnswer(sa);
        answerSheetMapper.insertAnswers(answerSheet);
    }
}
