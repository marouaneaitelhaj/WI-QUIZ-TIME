package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Quiz.QuizDtoRsp;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.QuizRepository;
import com.wi.quiz.Services.Inter.QuizService;

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
public class QuizServiceImpl implements QuizService {
    
    private final QuizRepository QuizRepository;
    
    private final ModelMapper modelMapper;

    @Override
    public QuizDto save(QuizDto quizDto) {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz = QuizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDto.class);
    }

    @Override
    public QuizDto update(QuizDto quizDto, Long aLong) {
        Optional<Quiz> optionalQuiz = QuizRepository.findById(aLong);
        if (optionalQuiz.isEmpty()) {
            throw new NotFoundEx("Quiz not found for id: " + aLong);
        }
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz = QuizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Quiz> optionalQuiz = QuizRepository.findById(aLong);
        if (optionalQuiz.isEmpty()) {
            throw new NotFoundEx("Quiz not found for id: " + aLong);
        }
        QuizRepository.deleteById(aLong);
        return QuizRepository.findById(aLong).isEmpty();
    }

    @Override
    public QuizDtoRsp findOne(Long aLong) {
        Optional<Quiz> optionalQuiz = QuizRepository.findById(aLong);
        if (optionalQuiz.isEmpty()) {
            throw new NotFoundEx("Quiz not found for id: " + aLong);
        }
        Quiz quiz = optionalQuiz.get();
        return modelMapper.map(quiz, QuizDtoRsp.class);
    }

    @Override
    public Page<QuizDtoRsp> findAll(Pageable pageable) {
        Page<Quiz> quizzes = QuizRepository.findAll(pageable);
        return quizzes.map(quiz -> modelMapper.map(quiz, QuizDtoRsp.class));
    }
}
