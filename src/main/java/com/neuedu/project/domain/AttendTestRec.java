package com.neuedu.project.domain;

public class AttendTestRec {
    private String studentId;
    private int testId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public AttendTestRec(String studentId, int testId) {
        this.studentId = studentId;
        this.testId = testId;
    }
    public AttendTestRec() {

    }

    @Override
    public String toString() {
        return "AttendTestRecord{" +
                "studentId='" + studentId + '\'' +
                ", testId=" + testId +
                '}';
    }
}
