package com.neuedu.project.domain;

public class Score {


    private String teacherId;
    private int answerSheetId;
    private int choicesScore;
    private int subjectiveScore;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getAnswerSheetId() {
        return answerSheetId;
    }

    public void setAnswerSheetId(int answerSheetId) {
        this.answerSheetId = answerSheetId;
    }

    public int getChoicesScore() {
        return choicesScore;
    }

    public void setChoicesScore(int choicesScore) {
        this.choicesScore = choicesScore;
    }

    public int getSubjectiveScore() {
        return subjectiveScore;
    }

    public void setSubjectiveScore(int subjectiveScore) {
        this.subjectiveScore = subjectiveScore;
    }

    public Score(String teacherId, int answerSheetId, int choicesScore, int subjectiveScore) {
        this.teacherId = teacherId;
        this.answerSheetId = answerSheetId;
        this.choicesScore = choicesScore;
        this.subjectiveScore = subjectiveScore;
    }
    public Score(){

    }

    @Override
    public String toString() {
        return "Score{" +
                "teacherId='" + teacherId + '\'' +
                ", answerSheetId=" + answerSheetId +
                ", choicesScore=" + choicesScore +
                ", subjectiveScore=" + subjectiveScore +
                '}';
    }
}
