package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
