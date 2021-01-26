package com.prabhu.springboot.controller;

import com.prabhu.springboot.model.QuestionAnswer;
import com.prabhu.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/get")
    public String generateQuestion() {
        return "Please sum the numbers " + questionService.generateQuestion();
    }

    @PostMapping("/answer/check")
    public String checkAnswer(@RequestBody QuestionAnswer questionAnswer) {
        return questionService.checkAnswer(questionAnswer);
    }
}
