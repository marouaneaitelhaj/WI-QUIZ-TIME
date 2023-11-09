package com.wi.quiz.Services;

import com.wi.quiz.DTO.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public QuestionDto save(QuestionDto questionDto) throws Exception;

    public QuestionDto update(QuestionDto questionDto, Long id) throws Exception;

    public void delete(Long id) throws Exception;

    public QuestionDto findById(Long id) throws Exception;

    public List<QuestionDto> findAll() throws Exception;
}
