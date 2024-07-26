package com.rohan.quizapp.service;

import com.rohan.quizapp.model.Question;

import java.util.List;

public interface QuestionServiceImpl {
     List<Question> getQuestions();
     Question getQuizById(Integer id);
     public String deleteQuiz(Integer id);
     Question saveQuiz(Question question);
}
