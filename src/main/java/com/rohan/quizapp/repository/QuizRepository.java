package com.rohan.quizapp.repository;


import com.rohan.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository <Quiz,Integer> {

}
