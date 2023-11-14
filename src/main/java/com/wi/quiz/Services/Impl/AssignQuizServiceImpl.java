package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.AssignQuizDto;
import com.wi.quiz.DTO.Rsp.AssignQuizDtoRsp;
import com.wi.quiz.Repositories.AssignQuizRepository;
import com.wi.quiz.Services.Inter.AssignQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignQuizServiceImpl implements AssignQuizService {
    @Autowired
    private AssignQuizRepository AssignQuizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssignQuizDto save(AssignQuizDto assignQuizDto) {
        return null;
    }

    @Override
    public AssignQuizDto update(AssignQuizDto assignQuizDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public AssignQuizDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<AssignQuizDtoRsp> findAll() {
        return null;
    }
}
