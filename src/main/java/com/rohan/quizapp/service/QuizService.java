package com.rohan.quizapp.service;


import com.rohan.quizapp.model.AnswersWrapper;
import com.rohan.quizapp.model.Question;
import com.rohan.quizapp.model.QuestionWrapper;
import com.rohan.quizapp.model.Quiz;
import com.rohan.quizapp.repository.QuestionRepository;
import com.rohan.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements QuizServiceImpl{

    @Autowired
     QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;


    @Override
    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuesByCat(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Sucess", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizByid(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for (Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return  new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Integer> getAnswers(Integer id, List<AnswersWrapper> answers) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        List<Question> questions = quiz.getQuestion();

        int right = 0;
        int i = 0;
        for (AnswersWrapper answer : answers){
            if(answer.getAnswers().equals(questions.get(i).getRightanswer())) {
                right++;
            }
            i++;
        }
        return  new ResponseEntity<>(right, HttpStatus.OK);
    }
}
