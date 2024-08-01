package com.rohan.quizapp.service;

import com.rohan.quizapp.model.QuestionWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizServiceImpl {
    ResponseEntity<String> createQuiz(String category, Integer numQ, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizByid(Integer id);
}
