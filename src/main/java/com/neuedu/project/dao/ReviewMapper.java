package com.neuedu.project.dao;

import com.neuedu.project.domain.Review;
import com.neuedu.project.domain.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    /**
     * 添加评教信息
     *
     * @param review 新的评教表
     */
    void insertReview(Review review);

    /**
     * 老师获取这一科的评教信息
     *
     * @param courseId 课程Id
     * @return 老师的评教信息
     */
    List<Review> queryReviewCourse(int courseId);

    /**
     * 学生获取一评教的课程
     *
     * @param studentId 学生Id
     * @return 课程Id集合
     */
    List<Review> queryReviewDuclip(@Param("studentId") String studentId,@Param("courseId") int courseId);

}
