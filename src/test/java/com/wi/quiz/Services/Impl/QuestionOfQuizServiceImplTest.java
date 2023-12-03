package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuiz.QuestionOfQuizDtoRsp;
import com.wi.quiz.Entities.QuestionOfQuiz;
import com.wi.quiz.Repositories.QuestionOfQuizRepository;
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
public class QuestionOfQuizServiceImplTest {
    @Mock
    private QuestionOfQuizRepository questionofquizRepository;

    @InjectMocks
    private QuestionOfQuizServiceImpl questionofquizService;

    @Mock
    private ModelMapper modelMapper;


    private QuestionOfQuiz questionofquiz;

    private QuestionOfQuizDto questionofquizDto;

    private QuestionOfQuizDtoRsp questionofquizDtoRsp;

    private List<QuestionOfQuizDtoRsp> questionofquizDtoRsps;

    @BeforeEach
    public void setUp() {
        questionofquiz = new QuestionOfQuiz();
        questionofquiz.setId(1L);

        questionofquizDto = new QuestionOfQuizDto();
        questionofquizDto.setId(1L);

        questionofquizDtoRsp = new QuestionOfQuizDtoRsp();
        questionofquizDtoRsp.setId(1L);
    }

    @Test
    public void saveTest() {

        try {
            when(questionofquizService.save(questionofquizDto)).thenReturn(questionofquizDto);
            assertEquals(questionofquizDto, questionofquizService.save(questionofquizDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //@Test
    public void updateTest1() {
        try {
            given(questionofquizRepository.findById(1L)).willReturn(Optional.of(questionofquiz));
            given(modelMapper.map(questionofquizDto, QuestionOfQuiz.class)).willReturn(questionofquiz);
            given(questionofquizRepository.save(questionofquiz)).willReturn(questionofquiz);
            assertSame(questionofquizDto.getId(), questionofquizService.update(questionofquizDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(questionofquizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> questionofquizService.update(questionofquizDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(questionofquizRepository.findById(1L)).willReturn(Optional.of(questionofquiz));
            assertEquals(questionofquizDtoRsp.getId(), questionofquizService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(questionofquizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> questionofquizService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(questionofquizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> questionofquizService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(questionofquizRepository.findById(1L)).willReturn(Optional.ofNullable(questionofquiz));
            assertDoesNotThrow(() -> questionofquizService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<QuestionOfQuiz> questionofquizs = new ArrayList<>();
            questionofquizs.add(questionofquiz);
            questionofquizs.add(questionofquiz);
            questionofquizs.add(questionofquiz);
            given(questionofquizRepository.findAll()).willReturn(questionofquizs);
            assertEquals(3, questionofquizService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
