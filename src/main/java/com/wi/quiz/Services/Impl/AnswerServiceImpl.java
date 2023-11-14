package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.AnswerDto;
import com.wi.quiz.DTO.Rsp.AnswerDtoRsp;
import com.wi.quiz.Repositories.AnswerRepository;
import com.wi.quiz.Services.Inter.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository AnswerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDto save(AnswerDto answerDto) {
        return null;
    }

    @Override
    public AnswerDto update(AnswerDto answerDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public AnswerDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<AnswerDtoRsp> findAll() {
        return null;
    }
}
