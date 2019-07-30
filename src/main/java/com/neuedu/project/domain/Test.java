package com.neuedu.project.domain;

/**
 * 考试表，由一组题目组成。
 */
public class Test {

    private int courseId;

    private int testId;

    private String choiceQuestionIds;

    private String subjectiveQuestionIds;


    public Test() {
    }

    public Test(int courseId, int testId, String choiceQuestionIds, String subjectiveQuestionIds) {
        this.courseId = courseId;
        this.testId = testId;
        this.choiceQuestionIds = choiceQuestionIds;
        this.subjectiveQuestionIds = subjectiveQuestionIds;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getChoiceQuestionIds() {
        return choiceQuestionIds;
    }

    public void setChoiceQuestionIds(String choiceQuestionIds) {
        this.choiceQuestionIds = choiceQuestionIds;
    }

    public String getSubjectiveQuestionIds() {
        return subjectiveQuestionIds;
    }

    public void setSubjectiveQuestionIds(String subjectiveQuestionIds) {
        this.subjectiveQuestionIds = subjectiveQuestionIds;
    }

    @Override
    public String toString() {
        return "Test{" +
                "courseId=" + courseId +
                ", id=" + testId +
                ", choiceQuestionIds='" + choiceQuestionIds + '\'' +
                ", subjectiveQuestionIds='" + subjectiveQuestionIds + '\'' +
                '}';
    }

}
