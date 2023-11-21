package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
public class QuestionServiceImplTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private ModelMapper modelMapper;


    private Question question;

    private QuestionDto questionDto;

    private QuestionDtoRsp questionDtoRsp;

    private List<QuestionDtoRsp> questionDtoRsps;

    @BeforeEach
    public void setUp() {
        question = new Question();
        question.setId(1L);
        question.setPoints(1);

        questionDto = new QuestionDto();
        questionDto.setId(1L);
        questionDto.setPoints(1);

        questionDtoRsp = new QuestionDtoRsp();
        questionDtoRsp.setId(1L);
        questionDtoRsp.setPoints(1);

    }

    @Test
    public void saveTest() {

        try {
            when(questionService.save(questionDto)).thenReturn(questionDto);
            assertEquals(questionDto, questionService.save(questionDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(questionRepository.findById(1L)).willReturn(Optional.of(question));
            given(modelMapper.map(questionDto, Question.class)).willReturn(question);
            given(questionRepository.save(question)).willReturn(question);
            assertSame(questionDto.getId(), questionService.update(questionDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(questionRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> questionService.update(questionDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {

        given(questionRepository.findById(1L)).willReturn(Optional.ofNullable(question));
        given(questionService.findOne(1L)).willReturn(questionDtoRsp);
        assertEquals(questionDtoRsp, questionService.findOne(1L));

    }

    @Test
    public void findOne2() {

        given(questionRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> questionService.findOne(1L));

    }

    @Test
    public void deleteTest() {
        try {
            given(questionRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> questionService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(questionRepository.findById(1L)).willReturn(Optional.ofNullable(question));
            assertDoesNotThrow(() -> questionService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Question> questions = new ArrayList<>();
            questions.add(question);
            questions.add(question);
            questions.add(question);
            given(questionRepository.findAll()).willReturn(questions);
            assertEquals(3, questionService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
