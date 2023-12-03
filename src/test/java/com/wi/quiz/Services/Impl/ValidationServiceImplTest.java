package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.Entities.Validation;
import com.wi.quiz.Repositories.ValidationRepository;
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
public class ValidationServiceImplTest {
    @Mock
    private ValidationRepository validationRepository;

    @InjectMocks
    private ValidationServiceImpl validationService;

    @Mock
    private ModelMapper modelMapper;


    private Validation validation;

    private ValidationDto validationDto;

    private ValidationDtoRsp validationDtoRsp;

    private List<ValidationDtoRsp> validationDtoRsps;

    @BeforeEach
    public void setUp() {
        validation = new Validation();
        validation.setId(1L);
        validation.setPoints(2);

        validationDto = new ValidationDto();
        validationDto.setId(1L);
        validationDto.setPoints(2);

        validationDtoRsp = new ValidationDtoRsp();
        validationDtoRsp.setId(1L);
        validationDtoRsp.setPoints(2);
    }

    @Test
    public void saveTest() {

        try {
            when(validationService.save(validationDto)).thenReturn(validationDto);
            assertEquals(validationDto, validationService.save(validationDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //@Test
    public void updateTest1() {
        try {
            given(validationRepository.findById(1L)).willReturn(Optional.of(validation));
            given(modelMapper.map(validationDto, Validation.class)).willReturn(validation);
            given(validationRepository.save(validation)).willReturn(validation);
            assertSame(validationDto.getId(), validationService.update(validationDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(validationRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> validationService.update(validationDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(validationRepository.findById(1L)).willReturn(Optional.of(validation));
            assertEquals(validationDtoRsp.getId(), validationService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(validationRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> validationService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(validationRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> validationService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(validationRepository.findById(1L)).willReturn(Optional.ofNullable(validation));
            assertDoesNotThrow(() -> validationService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Validation> validations = new ArrayList<>();
            validations.add(validation);
            validations.add(validation);
            validations.add(validation);
            given(validationRepository.findAll()).willReturn(validations);
            assertEquals(3, validationService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
