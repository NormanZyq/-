package com.neuedu.project.service;

import com.neuedu.project.dao.*;
import com.neuedu.project.domain.Review;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{


    private final TestMapper testMapper;

    private final QuestionMapper questionMapper;

    private final AttendTestRecMapper attendTestRecMapper;

    private final ArrangementMapper arrangementMapper;

    private final CourseMapper courseMapper;

    private final AnswerSheetMapper answerSheetMapper;

    private final ReviewMapper reviewMapper;


    /**
     * logger.
     */
    private final Logger log = Logger.getLogger(ReviewServiceImpl.class);

    @Autowired
    public ReviewServiceImpl(TestMapper testMapper,
                            QuestionMapper questionMapper,
                            AttendTestRecMapper attendTestRecMapper,
                            ArrangementMapper arrangementMapper,
                            CourseMapper courseMapper,
                            AnswerSheetMapper answerSheetMapper,
                            ReviewMapper reviewMapper) {
        this.testMapper = testMapper;
        this.questionMapper = questionMapper;
        this.attendTestRecMapper = attendTestRecMapper;
        this.arrangementMapper = arrangementMapper;
        this.courseMapper = courseMapper;
        this.answerSheetMapper = answerSheetMapper;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public void studentReviewStore(String studentId, int courseId, String content){
        List<Review> reviews = reviewMapper.queryReviewDuclip(studentId,courseId);
        if(reviews != null && reviews.size()!=0)
            return;
        System.out.println("dvhbdihvddiwhvgdigvefwug");
        Review review = new Review();
        review.setStudentId(studentId);
        review.setCourseId(courseId);
        review.setContent(content);
        reviewMapper.insertReview(review);
    }

    @Override
    public double[] TeacherReviewQuery(int courseId){
        List<Review> reviews = reviewMapper.queryReviewCourse(courseId);
        if(reviews == null || reviews.size() == 0){
            return null;
        }
        double[] reviewScore = new double[4];
        //求总值
        for(Review review:reviews){
            String[] str = review.getContent().split(" ");
            for(int i = 0; i< Math.min(str.length,reviewScore.length); i++){
                int sum = Integer.parseInt(str[i]);
                reviewScore[i] += (double)sum;
            }
        }
        //求平均分
        for (int i=0;i<reviewScore.length;i++){
            //保留两位小数
            BigDecimal b = new BigDecimal(reviewScore[i]/(double) reviews.size());
            reviewScore[i] = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return reviewScore;
    }

    @Override
    public boolean DuclipReview(String studentId, int courseId){
        List<Review> reviews = reviewMapper.queryReviewDuclip(studentId,courseId);
        if(reviews != null || reviews.size() == 0)
            return true;
        else
            return false;
    }
}
