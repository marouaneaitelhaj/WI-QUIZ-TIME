package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoRsp;
import com.wi.quiz.Entities.QuestionOfQuiz;
import com.wi.quiz.Repositories.QuestionOfQuizRepository;
import com.wi.quiz.Services.Inter.QuestionOfQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionOfQuizServiceImpl implements QuestionOfQuizService {
    @Autowired
    private QuestionOfQuizRepository questionOfQuizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionOfQuizDto save(QuestionOfQuizDto questionOfQuizDto) {
        QuestionOfQuiz questionOfQuiz = modelMapper.map(questionOfQuizDto, QuestionOfQuiz.class);
        questionOfQuiz = questionOfQuizRepository.save(questionOfQuiz);
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDto.class);
    }

    @Override
    public QuestionOfQuizDto update(QuestionOfQuizDto questionOfQuizDto, Long aLong) {
        Optional<QuestionOfQuiz> optionalQuestionOfQuiz = questionOfQuizRepository.findById(aLong);
        if (optionalQuestionOfQuiz.isEmpty()) {
            throw new RuntimeException("QuestionOfQuiz not found for id: " + aLong);
        }
        QuestionOfQuiz questionOfQuiz = modelMapper.map(questionOfQuizDto, QuestionOfQuiz.class);
        questionOfQuiz = questionOfQuizRepository.save(questionOfQuiz);
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<QuestionOfQuiz> optionalQuestionOfQuiz = questionOfQuizRepository.findById(aLong);
        if (optionalQuestionOfQuiz.isEmpty()) {
            throw new RuntimeException("QuestionOfQuiz not found for id: " + aLong);
        }
        questionOfQuizRepository.deleteById(aLong);
        return questionOfQuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public QuestionOfQuizDtoRsp findOne(Long aLong) {
        Optional<QuestionOfQuiz> optionalQuestionOfQuiz = questionOfQuizRepository.findById(aLong);
        if (optionalQuestionOfQuiz.isEmpty()) {
            throw new RuntimeException("QuestionOfQuiz not found for id: " + aLong);
        }
        QuestionOfQuiz questionOfQuiz = optionalQuestionOfQuiz.get();
        return modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class);
    }

    @Override
    public List<QuestionOfQuizDtoRsp> findAll() {
        List<QuestionOfQuiz> questionOfQuizList = questionOfQuizRepository.findAll();
        return questionOfQuizList.stream().map(questionOfQuiz -> modelMapper.map(questionOfQuiz, QuestionOfQuizDtoRsp.class)).toList();
    }
}
