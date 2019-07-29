package com.neuedu.project.dao;

import com.neuedu.project.domain.Arrangement;
import com.neuedu.project.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArrangementMapper {

    /**
     * 教师创建考试安排.
     *
     * @param arrangement
     *
     */
    void addArrangement(Arrangement arrangement);

    /**
     * 教师更新考试安排.
     *
     * @param arrangement
     *
     */
    void updateArrangement(Arrangement arrangement);

    /**
     * 教师删除考试安排.
     *
     * @param arrangeId
     *
     */
    void deleteArrangement(int arrangeId);

    List<Arrangement> getTestArrangement(String studentId);



}
