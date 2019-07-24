package com.neuedu.project.domain;

import com.neuedu.project.domain.utils.QuestionUtils;

import java.util.*;

public class ChoiceQuestion extends Question {

    private Map<String, String> choices;

    private Set<String> answers;

    public ChoiceQuestion(Map<String, String> choices) {
        this.choices = choices;
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
                .parseChoiseString(choicesString);

        answers = new HashSet<>();
        String[] answerArray = rightAnswerString.split("\\s+");

        this.answers.addAll(Arrays.asList(answerArray));


    }

    public String getChoiceContent(String choice) {
        return choices.getOrDefault(choice.toUpperCase(), "");
    }

    public String getRightAnswer() {
        return super.getRightAnswerString();
    }

    public boolean isMultipleChoice() {
        return answers.size() > 1;
    }

}
