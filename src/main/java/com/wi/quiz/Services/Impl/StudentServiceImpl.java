package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Student.StudentDtoRsp;
import com.wi.quiz.DTO.Student.StudentDto;
import com.wi.quiz.Entities.Student;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.StudentRepository;
import com.wi.quiz.Services.Inter.StudentService;

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
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository studentService;
    
    private final ModelMapper modelMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentService.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto update(StudentDto studentDto, Long aLong) {
        Optional<Student> optionalStudent = studentService.findById(aLong);
        if (optionalStudent.isEmpty()) {
            throw new NotFoundEx("Student not found for id: " + aLong);
        }
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentService.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Student> optionalStudent = studentService.findById(aLong);
        if (optionalStudent.isEmpty()) {
            throw new NotFoundEx("Student not found for id: " + aLong);
        }
        studentService.deleteById(aLong);
        return studentService.findById(aLong).isEmpty();
    }

    @Override
    public StudentDtoRsp findOne(Long aLong) {
        Optional<Student> optionalStudent = studentService.findById(aLong);
        if (optionalStudent.isEmpty()) {
            throw new NotFoundEx("Student not found for id: " + aLong);
        }
        Student student = optionalStudent.get();
        return modelMapper.map(student, StudentDtoRsp.class);
    }

    @Override
    public Page<StudentDtoRsp> findAll(Pageable pageable) {
        Page<Student> students = studentService.findAll(pageable);
        return students.map(student -> modelMapper.map(student, StudentDtoRsp.class));
    }
}
