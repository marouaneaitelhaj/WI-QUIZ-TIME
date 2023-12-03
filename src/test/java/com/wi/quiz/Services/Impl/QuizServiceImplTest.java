package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Quiz.QuizDtoRsp;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Repositories.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class QuizServiceImplTest {
    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizServiceImpl quizService;

    @Mock
    private ModelMapper modelMapper;


    private Quiz quiz;

    private QuizDto quizDto;

    private QuizDtoRsp quizDtoRsp;

    private List<QuizDtoRsp> quizDtoRsps;

    @BeforeEach
    public void setUp() {
        quiz = new Quiz();
        quiz.setId(1L);

        quizDto = new QuizDto();
        quizDto.setId(1L);

        quizDtoRsp = new QuizDtoRsp();
        quizDtoRsp.setId(1L);
    }

    @Test
    public void saveTest() {

        try {
            when(quizService.save(quizDto)).thenReturn(quizDto);
            assertEquals(quizDto, quizService.save(quizDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(quizRepository.findById(1L)).willReturn(Optional.of(quiz));
            given(modelMapper.map(quizDto, Quiz.class)).willReturn(quiz);
            given(quizRepository.save(quiz)).willReturn(quiz);
            assertSame(quizDto.getId(), quizService.update(quizDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(quizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> quizService.update(quizDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(quizRepository.findById(1L)).willReturn(Optional.of(quiz));
            assertEquals(quizDtoRsp.getId(), quizService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(quizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> quizService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(quizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> quizService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(quizRepository.findById(1L)).willReturn(Optional.ofNullable(quiz));
            assertDoesNotThrow(() -> quizService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Quiz> quizs = new ArrayList<>();
            quizs.add(quiz);
            quizs.add(quiz);
            quizs.add(quiz);
            given(quizRepository.findAll()).willReturn(quizs);
            assertEquals(3, quizService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
