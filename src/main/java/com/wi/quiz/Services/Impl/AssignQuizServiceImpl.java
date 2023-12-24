package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.AssignQuiz.AssignQuizDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.AssignQuizRepository;
import com.wi.quiz.Services.Inter.AssignQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
            throw new NotFoundEx("AssignQuiz not found for id: " + aLong);
        }
        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);
        assignQuiz = assignQuizRepository.save(assignQuiz);
        return modelMapper.map(assignQuiz, AssignQuizDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new NotFoundEx("AssignQuiz not found for id: " + aLong);
        }
        assignQuizRepository.deleteById(aLong);
        return assignQuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public AssignQuizDtoRsp findOne(Long aLong) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(aLong);
        if (optionalAssignQuiz.isEmpty()) {
            throw new NotFoundEx("AssignQuiz not found for id: " + aLong);
        }
        AssignQuiz assignQuiz = optionalAssignQuiz.get();
        return modelMapper.map(assignQuiz, AssignQuizDtoRsp.class);
    }

    @Override
    public Page<AssignQuizDtoRsp> findAll(Pageable pageable) {
        Page<AssignQuiz> assignQuizList = assignQuizRepository.findAll(pageable);
        return assignQuizList.map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizDtoRsp.class));
    }

    @Override
    public int getScore(Long id) {
        Optional<AssignQuiz> optionalAssignQuiz = assignQuizRepository.findById(id);
        if (optionalAssignQuiz.isEmpty()) {
            throw new NotFoundEx("AssignQuiz not found for id: " + id);
        }
        AssignQuiz assignQuiz = optionalAssignQuiz.get();
        int score = 0;
        for (Answer answer : assignQuiz.getAnswers()) {
            if (answer.getValidation().isCorrect()) {
                score = score + answer.getValidation().getPoints();
            }
        }
        return score;
    }
}
