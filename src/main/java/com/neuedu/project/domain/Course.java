package com.neuedu.project.domain;

import java.util.List;

public class Course {

    private int courseId;

    private String courseName;

    private List<User> teachers;

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<User> getTeachers() {
        return teachers;
    }
}
