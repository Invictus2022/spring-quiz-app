package com.rohan.quizapp.service;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements QuestionServiceImpl {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestions(){
        List<Question> allQuestions = questionRepository.findAll();
        return  allQuestions;
    }

    @Override
    public Question getQuizById(Integer id){
        Optional<Question> singleQuestion = questionRepository.findById(id);
        if (singleQuestion.isPresent()) {
            return singleQuestion.get();
        }else {
            return  null;
        }
    }
}
