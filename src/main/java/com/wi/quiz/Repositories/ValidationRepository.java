package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
}
