package com.rohan.quizapp.controller;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping("/allquiz")
    public List<Question> getAllQuestions(){
        return questionService.getQuestions();
    }

    @GetMapping("/quiz/{id}")
    public Question getQuizById(@PathVariable("id") Integer id){
        return questionService.getQuizById(id);
    }

    @DeleteMapping("/quiz/{id}")
    public String deleteQuiz(@PathVariable("id") Integer id){
        return questionService.deleteQuiz(id);
    }
    @PostMapping("/quiz")
    public Question saveQuiz(@RequestBody Question quiz){
        return  questionService.saveQuiz(quiz);
    }
}
