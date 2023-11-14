package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Rsp.ValidationDtoRsp;
import com.wi.quiz.DTO.ValidationDto;
import com.wi.quiz.Repositories.ValidationRepository;
import com.wi.quiz.Services.Inter.ValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ValidationDto save(ValidationDto validationDto) {
        return null;
    }

    @Override
    public ValidationDto update(ValidationDto validationDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public ValidationDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<ValidationDtoRsp> findAll() {
        return null;
    }
}
