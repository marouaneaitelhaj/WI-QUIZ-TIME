package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Req.AssignQuizDto;
import com.wi.quiz.DTO.Rsp.AssignQuizDtoRsp;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Repositories.AssignQuizRepository;
import com.wi.quiz.Services.Inter.AssignQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignQuizServiceImpl implements AssignQuizService {
    @Autowired
    private AssignQuizRepository assignQuizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssignQuizDto save(AssignQuizDto assignQuizDto) {
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
        assignQuiz = assignQuizRepository.save(assignQuiz);
        return modelMapper.map(assignQuiz, AssignQuizDto.class);
    }

    @Override
    public AssignQuizDto update(AssignQuizDto assignQuizDto, Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new RuntimeException("AssignQuiz not found for id: " + aLong);
        }
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
        assignQuiz = assignQuizRepository.save(assignQuiz);
        return modelMapper.map(assignQuiz, AssignQuizDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new RuntimeException("AssignQuiz not found for id: " + aLong);
        }
        assignQuizRepository.deleteById(aLong);
        return assignQuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public AssignQuizDtoRsp findOne(Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new RuntimeException("AssignQuiz not found for id: " + aLong);
        }
        AssignQuiz assignQuiz = optionalAssignQuiz.get();
        return modelMapper.map(assignQuiz, AssignQuizDtoRsp.class);
    }

    @Override
    public List<AssignQuizDtoRsp> findAll() {
        List<AssignQuiz> assignQuizList = assignQuizRepository.findAll();
        return assignQuizList.stream().map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizDtoRsp.class)).toList();
    }
}
