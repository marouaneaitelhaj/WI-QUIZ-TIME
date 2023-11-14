package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Rsp.StudentDtoRsp;
import com.wi.quiz.DTO.StudentDto;
import com.wi.quiz.Services.Inter.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentService StudentService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto update(StudentDto studentDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public StudentDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<StudentDtoRsp> findAll() {
        return null;
    }
}
