package com.wi.quiz.Services;

import com.wi.quiz.Entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public Question save(Question question);

    public Question update(Question question, Long id);

    public void delete(Long id);

    public Question findById(Long id);

    public List<Question> findAll();
}
