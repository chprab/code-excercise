package com.prabhu.springboot.controller;

import com.prabhu.springboot.model.QuestionAnswer;
import com.prabhu.springboot.restclient.ClientRestClient;
import com.prabhu.springboot.restclient.ServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceClientSimulator {

    @Autowired
    private ServiceRestClient serviceRestClient;

    @Autowired
    private ClientRestClient clientRestClient;

    @GetMapping("/service/client/colloborate")
    public String colloborate() {

        String askQuestion = clientRestClient.askQuestion();
        System.out.println("Client : " + askQuestion);
        String question = serviceRestClient.generateQuestion();
        System.out.println("Service : " + question);

        //dummy answer
        String dummyAnswer = "111";
        System.out.println("Client : " + question + " and the answer is " + dummyAnswer);
        QuestionAnswer dummyQuestionAnswer = new QuestionAnswer(question, dummyAnswer);
        String dummyResult = serviceRestClient.checkAnswer(dummyQuestionAnswer);
        System.out.println("Service : " + dummyResult);

        String answer = clientRestClient.getAnswer(question);
        System.out.println("Client : Sorry. " + question + " and the answer is " + answer);
        QuestionAnswer questionAnswer = new QuestionAnswer(question, answer);
        String result = serviceRestClient.checkAnswer(questionAnswer);
        System.out.println("Service : " + result);

        StringBuilder sb = new StringBuilder();
        sb.append("Client : " + askQuestion).append("\n");
        sb.append("Service : " + question).append("\n");
        sb.append("Client : " + question + " and the answer is " + dummyAnswer).append("\n");
        sb.append("Service : " + dummyResult).append("\n");
        sb.append("Client : Sorry. " + question + " and the answer is " + answer).append("\n");
        sb.append("Service : " + result);

        return sb.toString();
    }
}
