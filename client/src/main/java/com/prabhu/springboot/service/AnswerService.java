package com.prabhu.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    public int calculateSum(String query) {
        String[] str = query.split(",");
        int i = 0;
        int sum = 0;
        for(String s : str) {
            if(i == 0)
                sum += Integer.parseInt(s.substring(str[0].length()-1));
            else
                sum += Integer.parseInt(s);

            i++;
        }
        return sum;

    }
}
