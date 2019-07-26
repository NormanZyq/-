package com.neuedu.project.domain;

import com.neuedu.project.domain.utils.QuestionUtils;

import java.util.*;

public class ChoiceQuestion extends Question {

    private final Map<String, String> choices;

    private final Set<String> answers;

//    public ChoiceQuestion(Map<String, String> choices) {
//        this.choices = choices;
//    }

    public ChoiceQuestion(Question simpleQuestion) {
        super(simpleQuestion.getCourseId(),
                simpleQuestion.getQuestionType(),
                simpleQuestion.getQuestionContent(),
                simpleQuestion.getChoicesString(),
                simpleQuestion.getRightAnswerString(),
                simpleQuestion.getResources());
        choices = QuestionUtils.getInstance()
                .parseChoiceString(simpleQuestion.getChoicesString());

        answers = new HashSet<>();
        String[] answerArray = simpleQuestion.getRightAnswerString()
                .split("\\s+");

        this.answers.addAll(Arrays.asList(answerArray));
    }

    /**
     * complete constructor for choice question.
     * after add all things, choices and answers will be parsed.
     *
     * @param courseId
     * @param questionType
     * @param questionContent
     * @param choicesString
     * @param rightAnswerString
     * @param resources
     */
    public ChoiceQuestion(int courseId,
                          int questionType,
                          String questionContent,
                          String choicesString, String rightAnswerString,
                          String resources) {
        super(courseId, questionType, questionContent,
                choicesString, rightAnswerString, resources);

        choices = QuestionUtils.getInstance()
                .parseChoiceString(choicesString);

        answers = new HashSet<>();
        String[] answerArray = rightAnswerString.split("\\s+");

        this.answers.addAll(Arrays.asList(answerArray));
    }

    public String getChoiceContent(String choice) {
        return choices.getOrDefault(choice.toUpperCase(), "");
    }


    public Set<String> getRightAnswer() {
        return Collections.unmodifiableSet(this.answers);
    }

    @Override
    public String toString() {
        return "ChoiceQuestion{" +
                "choices=" + choices +
                ", answers=" + answers +
                '}';
    }

    /**
     * 返回此选择题是否为多选题。
     * @return  多选题返回true，单选返回false
     */
    public boolean isMultipleChoice() {
        return answers.size() > 1;
    }



}
