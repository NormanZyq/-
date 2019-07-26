package com.neuedu.project.domain;

/**
 * 考试表，由一组题目组成。
 */
public class Test {

    private int courseId;

    private int id;

    private String choiceQuestionIds;

    private String subjectiveQuestionIds;

    private String releaseDate;

    private int duration;

    public Test() {
    }

    public Test(int courseId, int id, String choiceQuestionIds, String subjectiveQuestionIds, String releaseDate, int duration) {
        this.courseId = courseId;
        this.id = id;
        this.choiceQuestionIds = choiceQuestionIds;
        this.subjectiveQuestionIds = subjectiveQuestionIds;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Test{" +
                "courseId=" + courseId +
                ", id=" + id +
                ", choiceQuestionIds='" + choiceQuestionIds + '\'' +
                ", subjectiveQuestionIds='" + subjectiveQuestionIds + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", duration=" + duration +
                '}';
    }

}
