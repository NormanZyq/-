package com.neuedu.project;

import com.neuedu.project.dao.CourseMapper;
import com.neuedu.project.dao.QuestionMapper;
import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.Course;
import com.neuedu.project.domain.Question;
import com.neuedu.project.domain.User;
import com.neuedu.project.domain.factories.QuestionFactory;
import com.neuedu.project.domain.utils.QuestionUtils;
import com.neuedu.project.service.CourseService;
import com.neuedu.project.service.QuestionService;
import com.neuedu.project.service.UserService;
import com.neuedu.project.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineTestSystemApplicationTests {

    @Autowired
    private CourseService courseService;

    @Autowired
    private QuestionService questionService;

    @Test
    public void contextLoads() {
        assert true;
    }


    private final String testTeacherId = "iii";
    private final int testCourseId = 1;
    private final String testCourseName = "语文";

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

}
