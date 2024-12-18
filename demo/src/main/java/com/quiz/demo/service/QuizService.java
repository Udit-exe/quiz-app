package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.User;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public boolean submitAnswer(Long questionId, String selectedOption) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if (questionOptional.isEmpty()) {
            throw new RuntimeException("Question not found.");
        }
        Question question = questionOptional.get();

        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found."));
        user.setTotalQuestionsAnswered(user.getTotalQuestionsAnswered() + 1);

        boolean isCorrect = question.getCorrectOption().equalsIgnoreCase(selectedOption);
        if (isCorrect) {
            user.setCorrectAnswers(user.getCorrectAnswers() + 1);
        }
        userRepository.save(user);

        return isCorrect;
    }

    public User getUserStats() {
        return userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found."));
    }
}
