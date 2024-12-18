package com.quiz.demo.controller;

import com.quiz.demo.model.Question;
import com.quiz.demo.model.User;
import com.quiz.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public String startQuiz() {
        return "New quiz session started.";
    }

    @GetMapping("/question")
    public Question getQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/answer")
    public String submitAnswer(@RequestParam Long questionId, @RequestParam String selectedOption) {
        boolean isCorrect = quizService.submitAnswer(questionId, selectedOption);
        return isCorrect ? "Correct answer!" : "Incorrect answer.";
    }

    @GetMapping("/stats")
    public User getStats() {
        return quizService.getUserStats();
    }
}
