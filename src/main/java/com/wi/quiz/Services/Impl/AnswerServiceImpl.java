package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.AnswerRepository;
import com.wi.quiz.Services.Inter.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnswerDto save(AnswerDto answerDto) {
        Answer answer = modelMapper.map(answerDto, Answer.class);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public AnswerDto update(AnswerDto answerDto, Long aLong) {
        Optional<Answer> optionalAnswer = answerRepository.findById(aLong);
        if (optionalAnswer.isEmpty()) {
            throw new NotFoundEx("Answer not found for id: " + aLong);
        }
        Answer answer = modelMapper.map(answerDto, Answer.class);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Answer> optionalAnswer = answerRepository.findById(aLong);
        if (optionalAnswer.isEmpty()) {
            throw new NotFoundEx("Answer not found for id: " + aLong);
        }
        answerRepository.deleteById(aLong);
        return answerRepository.findById(aLong).isEmpty();
    }

    @Override
    public AnswerDtoRsp findOne(Long aLong) {
        Optional<Answer> optionalAnswer = answerRepository.findById(aLong);
        if (optionalAnswer.isEmpty()) {
            throw new NotFoundEx("Answer not found for id: " + aLong);
        }
        Answer answer = optionalAnswer.get();
        return modelMapper.map(answer, AnswerDtoRsp.class);
    }

    @Override
    public List<AnswerDtoRsp> findAll() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream().map(answer -> modelMapper.map(answer, AnswerDtoRsp.class)).toList();
    }
}
