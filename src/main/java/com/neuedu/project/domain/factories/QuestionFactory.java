package com.neuedu.project.domain.factories;

import com.neuedu.project.domain.Question;

public class QuestionFactory {

    private String extract = "";

    /**
     * create a choice question with passed in choices and other arguments.
     *
     * @param courseId
     * @param content
     * @param choices
     * @param answer
     * @param resources
     * @return
     */
    public static Question choiceQuestion(int courseId,
                                          String content,
                                          String choices,
                                          String answer,
                                          String resources) {
        Question choiceQuestion = new Question(courseId, 0,
                content, choices, answer, resources);

        return choiceQuestion;
    }

    /**
     * create a subjective question with passed in arguments.
     * @param courseId
     * @param content
     * @param answer
     * @param resources
     * @return
     */
    public static Question subjectiveQuestion(int courseId,
                                              String content,
                                              String answer,
                                              String resources) {
        Question choiceQuestion = new Question(courseId, 1,
                content, answer, resources);

        return choiceQuestion;
    }
}
