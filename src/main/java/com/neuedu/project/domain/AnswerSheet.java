package com.neuedu.project.domain;

public class AnswerSheet {

    /**
     * 与考试信息、学生ID关联。
     */
    private int attendRecord;

    private int id;

    private String choiceQuestionAnswer;

    private String subjectiveQuestionAnswer;

    public AnswerSheet() {

    }

    public int getAttendRecord() {
        return attendRecord;
    }

    public void setAttendRecord(int attendRecord) {
        this.attendRecord = attendRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoiceQuestionAnswer() {
        return choiceQuestionAnswer;
    }

    public void setChoiceQuestionAnswer(String choiceQuestionAnswer) {
        this.choiceQuestionAnswer = choiceQuestionAnswer;
    }

    public String getSubjectiveQuestionAnswer() {
        return subjectiveQuestionAnswer;
    }

    public void setSubjectiveQuestionAnswer(String subjectiveQuestionAnswer) {
        this.subjectiveQuestionAnswer = subjectiveQuestionAnswer;
    }
}
