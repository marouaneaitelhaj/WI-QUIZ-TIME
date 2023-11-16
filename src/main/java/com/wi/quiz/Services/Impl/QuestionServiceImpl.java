package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Services.Inter.QuestionService;
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
    public QuestionDto save(QuestionDto questionDto) {
        
            Question question = modelMapper.map(questionDto, Question.class);
            questionRepository.save(question);
            return questionDto;
        
    }

    @Override
    public QuestionDto update(QuestionDto questionDto, Long aLong) {
        
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                Question question = modelMapper.map(questionDto, Question.class);
                question.setId(aLong);
                questionRepository.save(question);
                questionDto.setId(aLong);
                return questionDto;
            } else {
                throw new RuntimeException("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Question> question = questionRepository.findById(aLong);
            if (question.isPresent()) {
                questionRepository.deleteById(aLong);
                return questionRepository.findById(aLong).isEmpty();
            } else {
                throw new RuntimeException("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public QuestionDtoRsp findOne(Long aLong) {
        
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                return modelMapper.map(optionalQuestion.get(), QuestionDtoRsp.class);
            } else {
                throw new RuntimeException("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public List<QuestionDtoRsp> findAll() {
        
            List<Question> questions = questionRepository.findAll();
            return questions.stream().map(question -> modelMapper.map(question, QuestionDtoRsp.class)).toList();
        
    }
}
