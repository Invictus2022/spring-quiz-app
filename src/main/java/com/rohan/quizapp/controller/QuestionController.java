package com.rohan.quizapp.controller;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
