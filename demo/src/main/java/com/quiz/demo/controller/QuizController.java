package com.quiz.demo.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.User;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController{
   
    @Autowired
    public QuizService quizService;

    @PostMapping("/start")
    public String startQuiz(){
        return "New quiz session started.";
    }

    @GetMapping()
}