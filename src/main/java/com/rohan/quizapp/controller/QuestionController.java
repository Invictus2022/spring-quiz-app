package com.rohan.quizapp.controller;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquiz")
    public List<Question> getAllQuestions(){
        return questionService.getQuestions();
    }
}
