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
     * @param arrangement 考试安排
     */
    void addArrangement(Arrangement arrangement);

    /**
     * 教师更新考试安排.
     *
     * @param arrangement 考试安排
     */
    void updateArrangement(Arrangement arrangement);

    /**
     * 教师删除考试安排.
     *
     * @param arrangeId 安排ID
     */
    void deleteArrangement(int arrangeId);

    /**
     * 由考试ID获取考试安排信息.
     *
     * @param testId 考试ID
     * @return 考试安排对象
     */
    Arrangement getTestArrangement(int testId);


}
