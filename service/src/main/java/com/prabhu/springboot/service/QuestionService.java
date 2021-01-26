package com.prabhu.springboot.service;

import com.prabhu.springboot.model.QuestionAnswer;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class QuestionService {

    private static HashMap<String, Integer> answerMap = new HashMap<>();

    public int getRandomNumber() {
        int randomNumber;
        int minimum = 1;
        int maximum = 10 - minimum;

        randomNumber = (int) ((Math.random() * maximum) + minimum);
        return randomNumber;
    }

    public String generateQuestion() {

        List<String> numbers = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            numbers.add(String.valueOf(getRandomNumber()));
        }

        int sum = calculateSum(numbers);
        String ret = StringUtils.join(numbers, ',');
        answerMap.put(ret, sum);

        return ret;
    }

    private int calculateSum(List<String> list) {
        int sum = 0;
        for(String str : list)
            sum += Integer.parseInt(str);
        return sum;
    }

    public String checkAnswer(QuestionAnswer questionAnswer) {

        String answer = questionAnswer.getAnswer();

        String question = questionAnswer.getQuestion();

        String que = getList(question);

        String str = "";
        if(answerMap.get(que).equals(Integer.parseInt(answer))) {
            str = "That’s great";
        } else {
            str = "That’s wrong. Please try again";
        }

        return str;



    }

    private String getList(String str) {
        String[] strArr = str.split(",");

        String fstr = strArr[0].substring(strArr[0].length()-1) + "," + strArr[1] + "," + strArr[2];

        return fstr;
    }


}
