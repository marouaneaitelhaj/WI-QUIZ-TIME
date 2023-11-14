package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Rsp.TeacherDtoRsp;
import com.wi.quiz.DTO.TeacherDto;
import com.wi.quiz.Services.Inter.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherService TeacherService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        return null;
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public TeacherDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<TeacherDtoRsp> findAll() {
        return null;
    }
}
