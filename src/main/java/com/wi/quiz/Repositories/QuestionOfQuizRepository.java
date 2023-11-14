package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.QuestionOfQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOfQuizRepository extends JpaRepository<QuestionOfQuiz, Long> {
}
