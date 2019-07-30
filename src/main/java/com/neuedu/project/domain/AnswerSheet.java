package com.neuedu.project.domain;

public class AnswerSheet {

    /**
     * 与考试信息、学生ID关联。
     */
    private int attendRecordId;

    private int id;

    private String choiceQuestionAnswer;

    private String subjectiveQuestionAnswer;

    public AnswerSheet() {

    }

    public int getAttendRecordId() {
        return attendRecordId;
    }

    public void setAttendRecordId(int attendRecordId) {
        this.attendRecordId = attendRecordId;
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

    @Override
    public String toString() {
        return "AnswerSheet{" +
                "attendRecordId=" + attendRecordId +
                ", id=" + id +
                ", choiceQuestionAnswer='" + choiceQuestionAnswer + '\'' +
                ", subjectiveQuestionAnswer='" + subjectiveQuestionAnswer + '\'' +
                '}';
    }
}
