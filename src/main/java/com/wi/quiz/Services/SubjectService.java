package com.wi.quiz.Services;

import com.wi.quiz.Entities.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {


    public Subject save(Subject subject);

    public Subject update(Subject subject, Long id);

    public void delete(Long id);

    public Subject findById(Long id);

    public List<Subject> findAll();
}
