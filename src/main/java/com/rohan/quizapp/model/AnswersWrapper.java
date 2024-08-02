package com.rohan.quizapp.model;


import lombok.Data;

@Data
public class AnswersWrapper {
    private Integer id;
    private  String Answers;


    public String getAnswers() {
        return Answers;
    }
}
