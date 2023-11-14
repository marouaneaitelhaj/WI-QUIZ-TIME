package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuizDto;
import com.wi.quiz.DTO.Rsp.QuizDtoRsp;
import com.wi.quiz.Repositories.QuizRepository;
import com.wi.quiz.Services.Inter.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository QuizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuizDto save(QuizDto quizDto) {
        return null;
    }

    @Override
    public QuizDto update(QuizDto quizDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public QuizDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<QuizDtoRsp> findAll() {
        return null;
    }
}
