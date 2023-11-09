package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Services.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionDto save(QuestionDto questionDto) throws Exception {
        try {
            Question question = modelMapper.map(questionDto, Question.class);
            questionRepository.save(question);
            return questionDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public QuestionDto update(QuestionDto questionDto, Long id) throws Exception {
        try {
            Optional<Question> optionalQuestion = questionRepository.findById(id);
            if (optionalQuestion.isPresent()) {
                Question question = modelMapper.map(questionDto, Question.class);
                question.setId(id);
                questionRepository.save(question);
                return questionDto;
            } else {
                throw new Exception("Question not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<Question> question = questionRepository.findById(id);
            if (question.isPresent()) {
                questionRepository.deleteById(id);
            } else {
                throw new Exception("Question not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public QuestionDto findById(Long id) throws Exception {
        try {
            Optional<Question> question = questionRepository.findById(id);
            if (question.isPresent()) {
                QuestionDto questionDto = modelMapper.map(question.get(), QuestionDto.class);
                return questionDto;
            } else {
                throw new Exception("Question not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<QuestionDto> findAll() throws Exception {
        try {
            List<Question> questions = questionRepository.findAll();
            return questions.stream().map(question -> modelMapper.map(question, QuestionDto.class)).toList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
