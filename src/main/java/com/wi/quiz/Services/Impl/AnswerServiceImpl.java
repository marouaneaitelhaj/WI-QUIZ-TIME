package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.AnswerRepository;
import com.wi.quiz.Repositories.AssignQuizRepository;
import com.wi.quiz.Services.Inter.AnswerService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    
    private final AnswerRepository answerRepository;

    
    private final AssignQuizRepository assignQuizRepository;

    
    private final ModelMapper modelMapper;

    @Override
    public AnswerDtoRsp save(AnswerDto answerDto) {
        AssignQuiz assignQuiz = assignQuizRepository.findById(answerDto.getAssignQuiz().getId()).orElseThrow(() -> new NotFoundEx("AssignQuiz not found for id: " + answerDto.getAssignQuiz().getId()));
        //assignQuiz.getAnswers()
        Answer answer = modelMapper.map(answerDto, Answer.class);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDtoRsp.class);
    }

    @Override
    public AnswerDtoRsp update(AnswerDto answerDto, Long aLong) {
        Optional<Answer> optionalAnswer = answerRepository.findById(aLong);
        if (optionalAnswer.isEmpty()) {
            throw new NotFoundEx("Answer not found for id: " + aLong);
        }
        Answer answer = modelMapper.map(answerDto, Answer.class);
        answer = answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDtoRsp.class);
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
    public Page<AnswerDtoRsp> findAll(Pageable pageable) {
        Page<Answer> answers = answerRepository.findAll(pageable);
        return answers.map(answer -> modelMapper.map(answer, AnswerDtoRsp.class));
    }

    @Override
    public List<AnswerDto> save(List<AnswerDto> answers) {
        List<Answer> answerList = answers.stream().map(answerDto -> {
            AssignQuiz assignQuiz = assignQuizRepository.findById(answerDto.getAssignQuiz().getId()).orElseThrow(() -> new NotFoundEx("AssignQuiz not found for id: " + answerDto.getAssignQuiz().getId()));
            if (!assignQuiz.isPlayed()) {
                assignQuiz.setPlayed(true);
                assignQuizRepository.save(assignQuiz);
            }
            Answer answer = modelMapper.map(answerDto, Answer.class);
            answer.setAssignQuiz(assignQuiz);
            return answer;
        }).toList();
        answerList = answerRepository.saveAll(answerList);
        return answerList.stream().map(answer -> modelMapper.map(answer, AnswerDto.class)).toList();
    }
}
