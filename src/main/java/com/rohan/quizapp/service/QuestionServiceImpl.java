package com.rohan.quizapp.service;

import com.rohan.quizapp.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionServiceImpl {
     ResponseEntity<List<Question>> getQuestions();
     Question getQuizById(Integer id);
     public String deleteQuiz(Integer id);
     public String saveQuiz(Question quiz);
     ResponseEntity<List<Question>> getQuesByCategory(String category);
}
