package com.rohan.quizapp.service;


import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionService implements QuestionServiceImpl {
    @Autowired
    private QuestionRepository questionRepository;

//    Get all questions;
    @Override
    public ResponseEntity<List<Question>> getQuestions() {
        try {

            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

//    Get quiz by id;
    @Override
    public Question getQuizById(Integer id){
        Optional<Question> singleQuestion = questionRepository.findById(id);
        if (singleQuestion.isPresent()) {
            return singleQuestion.get();
        }else {
            return  null;
        }
    }

//     Save new Quiz;
    @Override
    public String saveQuiz(Question quiz){
         questionRepository.save(quiz);
         return "Data Successfully added";
    }


    @Override
    public String deleteQuiz(Integer id){
        if (questionRepository.findById(id).isPresent()){
            questionRepository.deleteById(id);
            return "Quiz successfully deleted";
        }else {
            return "No such quiz foud in database";
        }
    }


//    Get quiz by category.
    @Override
    public ResponseEntity<List<Question>> getQuesByCategory(String category){
        try{
        return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK) ;
    }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
