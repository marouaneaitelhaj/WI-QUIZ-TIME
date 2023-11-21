package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Entities.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    Page<Response> findAll(Pageable pageable);
}
