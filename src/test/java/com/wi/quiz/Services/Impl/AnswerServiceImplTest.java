package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Repositories.AnswerRepository;
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
public class AnswerServiceImplTest {
    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private AnswerServiceImpl answerService;

    @Mock
    private ModelMapper modelMapper;


    private Answer answer;

    private AnswerDto answerDto;

    private AnswerDtoRsp answerDtoRsp;

    private List<AnswerDtoRsp> answerDtoRsps;

    @BeforeEach
    public void setUp() {
        answer = new Answer();
        answer.setId(1L);

        answerDto = new AnswerDto();
        answerDto.setId(1L);

        answerDtoRsp = new AnswerDtoRsp();
        answerDtoRsp.setId(1L);
    }

    @Test
    public void saveTest() {

        try {
            when(answerService.save(answerDto)).thenReturn(answerDto);
            assertEquals(answerDto, answerService.save(answerDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(answerRepository.findById(1L)).willReturn(Optional.of(answer));
            given(modelMapper.map(answerDto, Answer.class)).willReturn(answer);
            given(answerRepository.save(answer)).willReturn(answer);
            assertSame(answerDto.getId(), answerService.update(answerDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(answerRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> answerService.update(answerDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(answerRepository.findById(1L)).willReturn(Optional.of(answer));
            assertEquals(answerDtoRsp.getId(), answerService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(answerRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> answerService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(answerRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> answerService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(answerRepository.findById(1L)).willReturn(Optional.ofNullable(answer));
            assertDoesNotThrow(() -> answerService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Answer> answers = new ArrayList<>();
            answers.add(answer);
            answers.add(answer);
            answers.add(answer);
            given(answerRepository.findAll()).willReturn(answers);
            assertEquals(3, answerService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
