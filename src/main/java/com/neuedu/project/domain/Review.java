package com.neuedu.project.domain;

public class Review {

    private String studentId;

    private int courseId;

    private String content;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Review(String studentId, int courseId, String content) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "studentId='" + studentId + '\'' +
                ", courseId=" + courseId +
                ", content='" + content + '\'' +
                '}';
    }

    public Review(){

    }


}
