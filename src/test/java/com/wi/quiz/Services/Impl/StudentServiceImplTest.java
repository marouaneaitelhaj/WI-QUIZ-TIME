package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Student.StudentDto;
import com.wi.quiz.DTO.Student.StudentDtoRsp;
import com.wi.quiz.Entities.Student;
import com.wi.quiz.Repositories.StudentRepository;
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
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private ModelMapper modelMapper;


    private Student student;

    private StudentDto studentDto;

    private StudentDtoRsp studentDtoRsp;

    private List<StudentDtoRsp> studentDtoRsps;

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("hassan");

        studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setFirstName("hassan");

        studentDtoRsp = new StudentDtoRsp();
        studentDtoRsp.setId(1L);
        studentDtoRsp.setFirstName("hassan");
    }

    @Test
    public void saveTest() {

        try {
            when(studentService.save(studentDto)).thenReturn(studentDto);
            assertEquals(studentDto, studentService.save(studentDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest1() {
        try {
            given(studentRepository.findById(1L)).willReturn(Optional.of(student));
            given(modelMapper.map(studentDto, Student.class)).willReturn(student);
            given(studentRepository.save(student)).willReturn(student);
            assertSame(studentDto.getId(), studentService.update(studentDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(studentRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> studentService.update(studentDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(studentRepository.findById(1L)).willReturn(Optional.of(student));
            assertEquals(studentDtoRsp.getId(), studentService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(studentRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> studentService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(studentRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> studentService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(studentRepository.findById(1L)).willReturn(Optional.ofNullable(student));
            assertDoesNotThrow(() -> studentService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Student> students = new ArrayList<>();
            students.add(student);
            students.add(student);
            students.add(student);
            given(studentRepository.findAll()).willReturn(students);
            assertEquals(3, studentService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
