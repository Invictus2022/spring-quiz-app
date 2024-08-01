package com.rohan.quizapp.controller;


import com.rohan.quizapp.model.QuestionWrapper;
import com.rohan.quizapp.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizServiceImpl quizService;

    @PostMapping("/create")
    public ResponseEntity <String> createQuiz(
            @RequestParam String category, @RequestParam Integer numQ ,@RequestParam String title)
    {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return  quizService.getQuizByid(id);
    }
}
