package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.AssignQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Long> {
    Page<AssignQuiz> findAll(Pageable pageable);

}
