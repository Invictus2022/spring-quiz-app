package com.rohan.quizapp.controller;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping("/ques")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getQuestions();
    }

    @GetMapping("/ques/{id}")
    public Question getQuizById(@PathVariable("id") Integer id){
        return questionService.getQuizById(id);
    }

    @DeleteMapping("/id/{id}")
    public String deleteQuiz(@PathVariable("id") Integer id){
        return questionService.deleteQuiz(id);
    }
    @PostMapping("/ques")
    public String saveQuiz(@RequestBody Question quiz){
          return questionService.saveQuiz(quiz);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuesByCategory(@PathVariable String category){
        return questionService.getQuesByCategory(category);
    }
}