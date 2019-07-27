package com.neuedu.project.dao;

import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.AttendTestRec;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendTestRecMapper {

    /**
     * 给学生添加考试信息（暂定：选择软件构造的学生，必须参加猴子过桥的考试）
     *
     * @param attendTestRec
     *
     */
    void addAttendTestRec(AttendTestRec attendTestRec);



    /**
     * 删去学生考试信息（未知用途：可能学生弃考了，亦或是教师停止授课，再者能留下都是精品）
     *
     * @param atrId 记录学生参加考试信息表的id
     *
     */
    void deleteAttendTestRec(int atrId);


}
