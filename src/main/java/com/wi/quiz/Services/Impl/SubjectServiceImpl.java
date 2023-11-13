package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Rsp.SubjectDtoRsp;
import com.wi.quiz.DTO.SubjectDto;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Repositories.SubjectRepository;
import com.wi.quiz.Services.Inter.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SubjectDto> save(SubjectDto subjectDto) {
        try {
            Subject subject = modelMapper.map(subjectDto, Subject.class);
            subjectRepository.save(subject);
            return ResponseEntity.ok(subjectDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<SubjectDto> update(SubjectDto subjectDto, Long aLong) {
        try {
            Optional<Subject> optionalSubject = subjectRepository.findById(aLong);
            if (optionalSubject.isPresent()) {
                Subject subject = modelMapper.map(subjectDto, Subject.class);
                subject.setId(aLong);
                subjectRepository.save(subject);
                return ResponseEntity.ok(subjectDto);
            } else {
                throw new RuntimeException("Subject not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> delete(Long aLong) {
        try {
            Optional<Subject> subject = subjectRepository.findById(aLong);
            if (subject.isPresent()) {
                subjectRepository.deleteById(aLong);
                return ResponseEntity.ok("Subject deleted successfully");
            } else {
                throw new RuntimeException("Subject not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<SubjectDtoRsp> findOne(Long aLong) {
        try {
            Optional<Subject> optionalSubject = subjectRepository.findById(aLong);
            if (optionalSubject.isPresent()) {
                SubjectDtoRsp subjectDtoRsp = modelMapper.map(optionalSubject.get(), SubjectDtoRsp.class);
                return ResponseEntity.ok(subjectDtoRsp);
            } else {
                throw new RuntimeException("Subject not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<SubjectDtoRsp>> findAll() {
        try {
            List<Subject> subjects = subjectRepository.findAll();
            List<SubjectDtoRsp> subjectDtoRsps = subjects.stream().map(subject -> modelMapper.map(subject, SubjectDtoRsp.class)).toList();
            return ResponseEntity.ok(subjectDtoRsps);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
