package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.DTO.Rsp.QuestionDtoRsp;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Services.Inter.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<QuestionDto> save(QuestionDto questionDto) {
        try {
            Question question = modelMapper.map(questionDto, Question.class);
            questionRepository.save(question);
            return ResponseEntity.ok(questionDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<QuestionDto> update(QuestionDto questionDto, Long aLong) {
        try {
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                Question question = modelMapper.map(questionDto, Question.class);
                question.setId(aLong);
                questionRepository.save(question);
                return ResponseEntity.ok(questionDto);
            } else {
                throw new RuntimeException("Question not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> delete(Long aLong) {
        try {
            Optional<Question> question = questionRepository.findById(aLong);
            if (question.isPresent()) {
                questionRepository.deleteById(aLong);
                return ResponseEntity.ok("Question deleted successfully");
            } else {
                throw new RuntimeException("Question not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<QuestionDtoRsp> findOne(Long aLong) {
        try {
            Optional<Question> optionalQuestion = questionRepository.findById(aLong);
            if (optionalQuestion.isPresent()) {
                QuestionDtoRsp questionDtoRsp = modelMapper.map(optionalQuestion.get(), QuestionDtoRsp.class);
                return ResponseEntity.ok(questionDtoRsp);
            } else {
                throw new RuntimeException("Question not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<QuestionDtoRsp>> findAll() {
        try {
            List<Question> questions = questionRepository.findAll();
            List<QuestionDtoRsp> questionDtoRsps = questions.stream().map(question -> modelMapper.map(question, QuestionDtoRsp.class)).toList();
            return ResponseEntity.ok(questionDtoRsps);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
