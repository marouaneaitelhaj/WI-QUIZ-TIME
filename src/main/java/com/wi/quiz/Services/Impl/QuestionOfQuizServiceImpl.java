package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionOfQuizDto;
import com.wi.quiz.DTO.Rsp.QuestionOfQuizDtoRsp;
import com.wi.quiz.Repositories.QuestionOfQuizRepository;
import com.wi.quiz.Services.Inter.QuestionOfQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionOfQuizServiceImpl implements QuestionOfQuizService {
    @Autowired
    private QuestionOfQuizRepository QuestionOfQuizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionOfQuizDto save(QuestionOfQuizDto questionOfQuizDto) {
        return null;
    }

    @Override
    public QuestionOfQuizDto update(QuestionOfQuizDto questionOfQuizDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public QuestionOfQuizDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<QuestionOfQuizDtoRsp> findAll() {
        return null;
    }
}
