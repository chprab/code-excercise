package com.prabhu.springboot.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ClientRestClient", url = "http://localhost:9096")
public interface ClientRestClient {

    @GetMapping("/ask")
    public String askQuestion();

    @PostMapping("/answer/get")
    public String getAnswer(@RequestBody String query);
}
