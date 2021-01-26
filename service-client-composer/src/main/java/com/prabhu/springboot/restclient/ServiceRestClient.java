package com.prabhu.springboot.restclient;

import com.prabhu.springboot.model.QuestionAnswer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ServiceRestClient", url = "http://localhost:9095")
public interface ServiceRestClient {

    @GetMapping("/question/get")
    public String generateQuestion();

    @PostMapping("/answer/check")
    public String checkAnswer(@RequestBody QuestionAnswer questionAnswer);
}
