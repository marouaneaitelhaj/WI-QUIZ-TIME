package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.SubjectDto;
import com.wi.quiz.DTO.SubjectRespDto;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Repositories.SubjectRepository;
import com.wi.quiz.Services.SubjectService;
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
    public SubjectDto save(SubjectDto subjectDto) throws Exception {
        try {
            Subject subject = modelMapper.map(subjectDto, Subject.class);
            subjectRepository.save(subject);
            return subjectDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public SubjectDto update(SubjectDto subjectDto, Long id) throws Exception {
        try {
            Optional<Subject> optionalSubject = subjectRepository.findById(id);
            if (optionalSubject.isPresent()) {
                Subject subject = modelMapper.map(subjectDto, Subject.class);
                subject.setId(id);
                subjectRepository.save(subject);
                return subjectDto;
            }else {
                throw new Exception("Subject not found for id: " + id);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<Subject> subject = subjectRepository.findById(id);
            if (subject.isPresent()) {
                subjectRepository.deleteById(id);
            }else {
                throw new Exception("Subject not found for id: " + id);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public SubjectRespDto findById(Long id) throws Exception {
        try {
            Optional<Subject> optionalSubject = subjectRepository.findById(id);
            if (optionalSubject.isPresent()) {
                Subject subject = optionalSubject.get();
                SubjectDto top = modelMapper.map(subject.getTop(), SubjectDto.class);
                List<SubjectDto> sub = subject.getSubs().stream().map(subject1 -> modelMapper.map(subject1, SubjectDto.class)).toList();
                SubjectRespDto subjectDtoResponse = modelMapper.map(subject, SubjectRespDto.class);
                subjectDtoResponse.setTop(top);
                subjectDtoResponse.setSubs(sub);
                return subjectDtoResponse;
            }else {
                throw new Exception("Subject not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<SubjectRespDto> findAll() throws Exception {
        try {
            List<Subject> subjects = subjectRepository.findAll();
            return subjects.stream().map(subject -> modelMapper.map(subject, SubjectRespDto.class)).toList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
