package com.quiz.demo.model;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String questionText;
    private String options;
    private String correctOption;

}