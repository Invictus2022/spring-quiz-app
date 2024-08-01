package com.rohan.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany
    private List<Question> question;

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}
