package com.wi.quiz.Services;

import com.wi.quiz.DTO.SubjectDto;
import com.wi.quiz.DTO.Rsp.SubjectResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {


    public SubjectDto save(SubjectDto subjectDto) throws Exception;

    public SubjectDto update(SubjectDto subjectDto, Long id) throws Exception;

    public void delete(Long id) throws Exception;

    public SubjectResponseDto findById(Long id) throws Exception;

    public List<SubjectResponseDto> findAll() throws Exception;
}
