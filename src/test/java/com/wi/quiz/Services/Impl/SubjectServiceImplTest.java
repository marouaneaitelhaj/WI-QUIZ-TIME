package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Subject.SubjectDto;
import com.wi.quiz.DTO.Subject.SubjectDtoRsp;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Repositories.SubjectRepository;
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
public class SubjectServiceImplTest {
    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Mock
    private ModelMapper modelMapper;


    private Subject subject;

    private SubjectDto subjectDto;

    private SubjectDtoRsp subjectDtoRsp;

    private List<SubjectDtoRsp> subjectDtoRsps;

    @BeforeEach
    public void setUp() {
        subject = new Subject();
        subject.setId(1L);
        subject.setName("music");

        subjectDto = new SubjectDto();
        subjectDto.setId(1L);
        subjectDto.setName("music");

        subjectDtoRsp = new SubjectDtoRsp();
        subjectDtoRsp.setId(1L);
        subjectDtoRsp.setName("music");
    }

    @Test
    public void saveTest() {

        try {
            when(subjectService.save(subjectDto)).thenReturn(subjectDto);
            assertEquals(subjectDto, subjectService.save(subjectDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(subjectRepository.findById(1L)).willReturn(Optional.of(subject));
            given(modelMapper.map(subjectDto, Subject.class)).willReturn(subject);
            given(subjectRepository.save(subject)).willReturn(subject);
            assertSame(subjectDto.getId(), subjectService.update(subjectDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(subjectRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> subjectService.update(subjectDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(subjectRepository.findById(1L)).willReturn(Optional.of(subject));
            assertEquals(subjectDtoRsp.getId(), subjectService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(subjectRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> subjectService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(subjectRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> subjectService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(subjectRepository.findById(1L)).willReturn(Optional.ofNullable(subject));
            assertDoesNotThrow(() -> subjectService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Subject> subjects = new ArrayList<>();
            subjects.add(subject);
            subjects.add(subject);
            subjects.add(subject);
            given(subjectRepository.findAll()).willReturn(subjects);
            assertEquals(3, subjectService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
