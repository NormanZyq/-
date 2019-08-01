package com.neuedu.project.domain;

/**
 * 申诉功能！！
 *
 * @author zyq
 */
public class Complaint {
    private int complainId;

    private String studentId;

    private int testId;

    private String content;

    private String reply;

    public Complaint() {
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complainId=" + complainId +
                ", studentId='" + studentId + '\'' +
                ", testId=" + testId +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
