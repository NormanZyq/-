package com.neuedu.project;

import com.neuedu.project.dao.CourseMapper;
import com.neuedu.project.dao.QuestionMapper;
import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.Course;
import com.neuedu.project.domain.Question;
import com.neuedu.project.domain.User;
import com.neuedu.project.domain.factories.QuestionFactory;
import com.neuedu.project.domain.utils.QuestionUtils;
import com.neuedu.project.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineTestSystemApplicationTests {

    private final String testTeacherId = "iii";

    private final int testCourseId = 1;

    private final String testCourseName = "语文";

    @Autowired
    private CourseService courseService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestService testService;

    @Autowired
    private ArrangeService arrangeService;

    @Test
    public void contextLoads() {
        assert true;
    }

    @Test
    public void testGetCourses() {
        List<Course> courses = courseService.getCourseByName(testCourseName);
        boolean containsName = false;
//        assert courses.size() == 2;
        for (Course course : courses) {
            if (testCourseName.equals(course.getCourseName())) {
                containsName = true;
//                break;
            }
        }
        assert containsName;
    }

    @Test
    public void testAddCourse() {
//        courseService.addCourse(testTeacherId, "Chinese");
    }

    @Test
    public void testAddTeacherToCourse() {
//        courseService.addTeacherToCourse(testTeacherId, testCourseId);
    }

    @Test
    public void testParse() {
        Question forQuery = new Question();
        forQuery.setCourseId(1);
        forQuery.setQuestionType(1);

        List<Question> results = questionService.getChoiceQuestionByCourseId(1);

        ChoiceQuestion cq = new ChoiceQuestion(results.get(0));
//        System.out.println(cq);
        List<ChoiceQuestion> choiceQuestions = QuestionUtils.getInstance().parseAsChoiceQuestions(results);

        System.out.println(choiceQuestions);
    }

   /* @Test
    public void testOJLD(){
        System.out.println(testService.Calcualte_OJLD(10,5));
        System.out.println(testService.Calcualte_OJLD(5,10));
        System.out.println(testService.Calcualte_OJLD(5,7));
        System.out.println(testService.Calcualte_OJLD(7,5));
        System.out.println(testService.Calcualte_OJLD(5,5));
    }*/

    @Test
    public void testTest() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        testService.autoCreateTest(1, 1, 0, currentTime, 90);
    }

    @Test
    public void testArrange() {
        arrangeService.arrangeTest(1, "2019-02-09 22:22:22", 100);
    }



    @Test
    public void testGetArrangement() {
        System.out.println(arrangeService.getTestArrangement("abc"));

    }

    @Test
    public void testGetStudentSelectedCourse() {
        System.out.println(courseService.getStudentCourse("abc"));
    }


}
