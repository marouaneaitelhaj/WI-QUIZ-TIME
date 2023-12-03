package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Teacher.TeacherDto;
import com.wi.quiz.DTO.Teacher.TeacherDtoRsp;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Repositories.TeacherRepository;
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
public class TeacherServiceImplTest {
    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Mock
    private ModelMapper modelMapper;


    private Teacher teacher;

    private TeacherDto teacherDto;

    private TeacherDtoRsp teacherDtoRsp;

    private List<TeacherDtoRsp> teacherDtoRsps;

    @BeforeEach
    public void setUp() {
        teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("hassan");

        teacherDto = new TeacherDto();
        teacherDto.setId(1L);
        teacherDto.setFirstName("hassan");

        teacherDtoRsp = new TeacherDtoRsp();
        teacherDtoRsp.setId(1L);
        teacherDtoRsp.setFirstName("hassan");
    }

    @Test
    public void saveTest() {

        try {
            when(teacherService.save(teacherDto)).thenReturn(teacherDto);
            assertEquals(teacherDto, teacherService.save(teacherDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(teacherRepository.findById(1L)).willReturn(Optional.of(teacher));
            given(modelMapper.map(teacherDto, Teacher.class)).willReturn(teacher);
            given(teacherRepository.save(teacher)).willReturn(teacher);
            assertSame(teacherDto.getId(), teacherService.update(teacherDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(teacherRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> teacherService.update(teacherDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(teacherRepository.findById(1L)).willReturn(Optional.of(teacher));
            assertEquals(teacherDtoRsp.getId(), teacherService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(teacherRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> teacherService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(teacherRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> teacherService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(teacherRepository.findById(1L)).willReturn(Optional.ofNullable(teacher));
            assertDoesNotThrow(() -> teacherService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Teacher> teachers = new ArrayList<>();
            teachers.add(teacher);
            teachers.add(teacher);
            teachers.add(teacher);
            given(teacherRepository.findAll()).willReturn(teachers);
            assertEquals(3, teacherService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
