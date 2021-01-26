package com.prabhu.springboot.controller;

import com.prabhu.springboot.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/ask")
    public String askQuestion() {
        return "Hey Service, can you provide me a question with numbers to add?";
    }

    @PostMapping("/answer/get")
    public String getAnswer(@RequestBody String query) {
        int sum = answerService.calculateSum(query);
        return String.valueOf(sum);
    }
}
