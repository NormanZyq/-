package com.neuedu.project;

import com.neuedu.project.dao.CourseMapper;
import com.neuedu.project.domain.Course;
import com.neuedu.project.domain.User;
import com.neuedu.project.service.CourseService;
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

}
