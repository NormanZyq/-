package com.neuedu.project.domain.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.project.domain.ChoiceQuestion;
import com.neuedu.project.domain.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionUtils {
    private static QuestionUtils ourInstance = new QuestionUtils();

    public static QuestionUtils getInstance() {
        return ourInstance;
    }

    private QuestionUtils() {
    }


    public Map<String, String> parseChoiceString(String choiceString) {

        // 待返回的map，key是选项，value是选项的内容
        Map<String, String> mapChoiceContent = new HashMap<>();

        // 根据choiceString解析出json对象
        JSONObject choices = JSON.parseObject(choiceString);

        //
        int choiceCount = choices.size();
        for (int i = 0; i < choiceCount; i++) {
            String lower = String.valueOf((char)(97 + i));
            String capital = String.valueOf((char) (65 + i));
            String choiceContent = choices.getString(lower);
            if (choiceContent == null) {
                choiceContent = choices.getString(capital);
                if (choiceContent == null) {
                    throw new RuntimeException();
                }
            }
            // now choiceContent has value
            mapChoiceContent.put(capital, choiceContent);
        }
        return mapChoiceContent;

    }


    public List<ChoiceQuestion> parseAsChoiceQuestions(List<Question> questions) {
        List<ChoiceQuestion> returnList = new ArrayList<>();
        for (Question q : questions) {
            returnList.add(new ChoiceQuestion(q));
        }
        return returnList;
    }


}
