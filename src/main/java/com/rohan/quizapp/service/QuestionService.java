package com.rohan.quizapp.service;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements QuestionServiceImpl {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestions(){
        List<Question> allQuestions = questionRepository.findAll();
        return  allQuestions;
    }
}
