package com.rohan.quizapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String category;
    private String questiontitle;

    public Integer getId() {
        return id;
    }

    public String getQuestiontitle() {
        return questiontitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightanswer;

    public String getRightanswer() {
        return rightanswer;
    }
    private String difficultylevel;
}
