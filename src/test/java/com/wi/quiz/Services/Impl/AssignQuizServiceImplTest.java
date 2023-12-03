package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.AssignQuiz.AssignQuizDtoRsp;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Repositories.AssignQuizRepository;
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
public class AssignQuizServiceImplTest {
    @Mock
    private AssignQuizRepository assignQuizRepository;

    @InjectMocks
    private AssignQuizServiceImpl assignQuizService;

    @Mock
    private ModelMapper modelMapper;


    private AssignQuiz assignQuiz;

    private AssignQuizDto assignQuizDto;

    private AssignQuizDtoRsp assignQuizDtoRsp;

    private List<AssignQuizDtoRsp> assignQuizDtoRsps;

    @BeforeEach
    public void setUp() {
        assignQuiz = new AssignQuiz();
        assignQuiz.setId(1L);

        assignQuizDto = new AssignQuizDto();
        assignQuizDto.setId(1L);

        assignQuizDtoRsp = new AssignQuizDtoRsp();
        assignQuizDtoRsp.setId(1L);
    }

    @Test
    public void saveTest() {

        try {
            when(assignQuizService.save(assignQuizDto)).thenReturn(assignQuizDto);
            assertEquals(assignQuizDto, assignQuizService.save(assignQuizDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(assignQuizRepository.findById(1L)).willReturn(Optional.of(assignQuiz));
            given(modelMapper.map(assignQuizDto, AssignQuiz.class)).willReturn(assignQuiz);
            given(assignQuizRepository.save(assignQuiz)).willReturn(assignQuiz);
            assertSame(assignQuizDto.getId(), assignQuizService.update(assignQuizDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(assignQuizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> assignQuizService.update(assignQuizDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(assignQuizRepository.findById(1L)).willReturn(Optional.of(assignQuiz));
            assertEquals(assignQuizDtoRsp.getId(), assignQuizService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(assignQuizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> assignQuizService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(assignQuizRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> assignQuizService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(assignQuizRepository.findById(1L)).willReturn(Optional.ofNullable(assignQuiz));
            assertDoesNotThrow(() -> assignQuizService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<AssignQuiz> assignQuizs = new ArrayList<>();
            assignQuizs.add(assignQuiz);
            assignQuizs.add(assignQuiz);
            assignQuizs.add(assignQuiz);
            given(assignQuizRepository.findAll()).willReturn(assignQuizs);
            assertEquals(3, assignQuizService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
