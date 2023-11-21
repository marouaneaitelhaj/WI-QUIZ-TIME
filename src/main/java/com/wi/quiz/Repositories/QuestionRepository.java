package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Question;
import com.wi.quiz.Entities.QuestionOfQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAll(Pageable pageable);
}
