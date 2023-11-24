package com.example.springgithubaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MainController {

    @GetMapping("/test")
    public String getTestString(){
        return "테스트";
    }
}
