package com.neuedu.project.domain;

import java.util.List;

public class Question {

    private Integer questionId = null;

    private Integer courseId;

    private Integer questionType;

    private String questionContent;

    private Integer score = 0;

    private String choicesString;

    private String rightAnswerString;

    private String resources;

    public Question() {

    }

    public Question(int courseId,
                    int questionType,
                    String questionContent,
                    String choicesString,
                    String rightAnswerString,
                    String resources) {
        this.courseId = courseId;
        this.questionType = questionType;
        this.questionContent = questionContent;
        this.choicesString = choicesString;
        this.rightAnswerString = rightAnswerString;
        this.resources = resources;
    }

    public Question(int courseId, int questionType, String questionContent, String rightAnswerString, String resources) {
        this.courseId = courseId;
        this.questionType = questionType;
        this.questionContent = questionContent;
        this.rightAnswerString = rightAnswerString;
        this.resources = resources;
    }

    public int getScore() {
        return score;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getChoicesString() {
        return choicesString;
    }

    public void setChoicesString(String choicesString) {
        this.choicesString = choicesString;
    }

    public String getRightAnswerString() {
        return rightAnswerString;
    }

    public void setRightAnswerString(String rightAnswerString) {
        this.rightAnswerString = rightAnswerString;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
}
