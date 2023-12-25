package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Services.Inter.QuestionService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    
    private final QuestionRepository questionRepository;

    
    private final ModelMapper modelMapper;

    @Override
    public QuestionDtoRsp save(QuestionDto questionDto) {
        
            Question question = modelMapper.map(questionDto, Question.class);
        return modelMapper.map(questionRepository.save(question), QuestionDtoRsp.class);
        
    }

    @Override
    public QuestionDtoRsp update(QuestionDto questionDto, Long aLong) {
        
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                Question question = modelMapper.map(questionDto, Question.class);
                question.setId(aLong);

                return modelMapper.map(questionRepository.save(question), QuestionDtoRsp.class);
            } else {
                throw new NotFoundEx("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Question> question = questionRepository.findById(aLong);
            if (question.isPresent()) {
                questionRepository.deleteById(aLong);
                return questionRepository.findById(aLong).isEmpty();
            } else {
                throw new NotFoundEx("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public QuestionDtoRsp findOne(Long aLong) {
        
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                return modelMapper.map(optionalQuestion.get(), QuestionDtoRsp.class);
            } else {
                throw new NotFoundEx("Question not found for id: " + aLong);
            }
        
    }

    @Override
    public Page<QuestionDtoRsp> findAll(Pageable pageable) {
        
            Page<Question> questions = questionRepository.findAll(pageable);
            return questions.map(question -> modelMapper.map(question, QuestionDtoRsp.class));
        
    }
}
