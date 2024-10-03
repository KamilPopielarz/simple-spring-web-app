package com.popielarz.simpleWebApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "Witam serdecznie :)";
    }

    @RequestMapping("/about")
    public String about(){
        return "Czego tu szukasz?";
    }
}
