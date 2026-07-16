package com.in28minutes.spring.learn_spring_framework.game.enterprise.example.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.in28minutes.spring.learn_spring_framework.game.enterprise.example.business.BusinessService;


@Component
public class MyWebController {

    @Autowired
    private BusinessService businessService;

    
    
    public MyWebController(BusinessService businessService) {
        this.businessService = businessService;
    }



    public long returnValueFromBusinessService(){
        return businessService.calculateSum();
    }



}







