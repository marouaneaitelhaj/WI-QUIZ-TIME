package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoRsp;
import com.wi.quiz.Entities.QuestionOfQuiz;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.QuestionOfQuizRepository;
import com.wi.quiz.Services.Inter.QuestionOfQuizService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionOfQuizServiceImpl implements QuestionOfQuizService {
    
    private final QuestionOfQuizRepository questionOfQuizRepository;
    
    private final ModelMapper modelMapper;

    @Override
    public QuestionOfQuizDto save(QuestionOfQuizDto questionOfQuizDto) {
        QuestionOfQuiz questionOfQuiz = modelMapper.map(questionOfQuizDto, QuestionOfQuiz.class);
        checkIfExist(questionOfQuizDto);
        questionOfQuiz = questionOfQuizRepository.save(questionOfQuiz);
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDto.class);
    }

    @Override
    public QuestionOfQuizDto update(QuestionOfQuizDto questionOfQuizDto, Long aLong) {
        Optional<QuestionOfQuiz> optionalQuestionOfQuiz = questionOfQuizRepository.findById(aLong);
        if (optionalQuestionOfQuiz.isEmpty()) {
            throw new NotFoundEx("QuestionOfQuiz not found for id: " + aLong);
        }
        QuestionOfQuiz questionOfQuiz = modelMapper.map(questionOfQuizDto, QuestionOfQuiz.class);
        checkIfExist(questionOfQuizDto);
        questionOfQuiz = questionOfQuizRepository.save(questionOfQuiz);
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        QuestionOfQuiz optionalQuestionOfQuiz = questionOfQuizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("QuestionOfQuiz not found for id: " + aLong));
        questionOfQuizRepository.deleteById(aLong);
        return questionOfQuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public QuestionOfQuizDtoRsp findOne(Long aLong) {
        QuestionOfQuiz questionOfQuiz = questionOfQuizRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("QuestionOfQuiz not found for id: " + aLong));
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class);
    }

    @Override
    public Page<QuestionOfQuizDtoRsp> findAll(Pageable pageable) {
        Page<QuestionOfQuiz> questionOfQuizList = questionOfQuizRepository.findAll(pageable);
        return questionOfQuizList.map(questionOfQuiz -> modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class));
    }

    @Override
    public void checkIfExist(QuestionOfQuizDto questionOfQuizDto) {
        Optional<QuestionOfQuiz> optionalQuestionOfQuiz = questionOfQuizRepository.findByQuestionIdAndQuizId(questionOfQuizDto.getQuestion().getId(), questionOfQuizDto.getQuiz().getId());
        if (optionalQuestionOfQuiz.isPresent()) {
            throw new NotFoundEx("QuestionOfQuiz already exist for questionId: " + questionOfQuizDto.getQuestion().getId() + " and quizId: " + questionOfQuizDto.getQuiz().getId());
        }
    }
}
