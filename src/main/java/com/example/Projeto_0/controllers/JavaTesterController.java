package com.example.Projeto_0.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/java/tester")
public class JavaTesterController {
    String name;
    int number;
    double height; 
    boolean football;
    String f;
    String letter;

    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class);
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getGreeting() {
    logger.info("Saying Hello to the world");
    return "Hello World";
    }
   
    @GetMapping(path = "/author",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor(@PathVariable("/author") String name, int number,double height, boolean football,String letter) {
    logger.info("displaying author, number, height, if's a fan of football, and letter");
        if(football = true) f="i am"; else f="not";


    return "Done by"+name+"with number"+number+".I am"+height+" tall and"+f+" a fan of football.";
    }
   
   
}
