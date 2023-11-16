package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Subject.SubjectDtoRsp;
import com.wi.quiz.DTO.Subject.SubjectDto;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Repositories.SubjectRepository;
import com.wi.quiz.Services.Inter.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        
            Subject subject = modelMapper.map(subjectDto, Subject.class);
            subjectRepository.save(subject);
            return subjectDto;
        
    }

    @Override
    public SubjectDto update(SubjectDto subjectDto, Long aLong) {
        
            Optional<Subject> optionalSubject = subjectRepository.findById(aLong);
            if (optionalSubject.isPresent()) {
                Subject subject = modelMapper.map(subjectDto, Subject.class);
                subject.setId(aLong);
                subjectRepository.save(subject);
                subjectDto.setId(aLong);
                return subjectDto;
            } else {
                throw new RuntimeException("Subject not found for id: " + aLong);
            }
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Subject> subject = subjectRepository.findById(aLong);
            if (subject.isPresent()) {
                subjectRepository.deleteById(aLong);
                return subjectRepository.findById(aLong).isEmpty();
            } else {
                throw new RuntimeException("Subject not found for id: " + aLong);
            }
        
    }

    @Override
    public SubjectDtoRsp findOne(Long aLong) {
        
            Optional<Subject> optionalSubject = subjectRepository.findById(aLong);
            if (optionalSubject.isPresent()) {
                return modelMapper.map(optionalSubject.get(), SubjectDtoRsp.class);
            } else {
                throw new RuntimeException("Subject not found for id: " + aLong);
            }
        
    }

    @Override
    public List<SubjectDtoRsp> findAll() {
        
            List<Subject> subjects = subjectRepository.findAll();
            return subjects.stream().map(subject -> modelMapper.map(subject, SubjectDtoRsp.class)).toList();
        
    }
}
