package com.neuedu.project.domain;

public class AttendTestRec {

    private int attendRecordId;
    /**
     * 学号。
     */
    private String studentId;

    /**
     * 考试ID
     */
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

    public AttendTestRec(int attendRecordId, String studentId, int testId) {
        //ToDo Maybe Wrong
        this.attendRecordId = attendRecordId;
        this.studentId = studentId;
        this.testId = testId;
    }

    public AttendTestRec() {

    }

    public int getAttendRecordId() {
        return attendRecordId;
    }

    public void setAttendRecordId(int attendRecordId) {
        this.attendRecordId = attendRecordId;
    }

    @Override
    public String toString() {
        return "AttendTestRec{" +
                "attendRecordId=" + attendRecordId +
                ", studentId='" + studentId + '\'' +
                ", testId=" + testId +
                '}';
    }
}
