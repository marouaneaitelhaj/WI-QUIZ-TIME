package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Entities.Response;
import com.wi.quiz.Repositories.ResponseRepository;
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
public class ResponseServiceImplTest {
    @Mock
    private ResponseRepository responseRepository;

    @InjectMocks
    private ResponseServiceImpl responseService;

    @Mock
    private ModelMapper modelMapper;


    private Response response;

    private ResponseDto responseDto;

    private ResponseDtoRsp responseDtoRsp;

    private List<ResponseDtoRsp> responseDtoRsps;

    @BeforeEach
    public void setUp() {
        response = new Response();
        response.setId(1L);


        responseDto = new ResponseDto();
        responseDto.setId(1L);


        responseDtoRsp = new ResponseDtoRsp();
        responseDtoRsp.setId(1L);


    }

    @Test
    public void saveTest() {
        try {
            when(responseService.save(responseDto)).thenReturn(responseDto);
            assertEquals(responseDto, responseService.save(responseDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest() {

        given(modelMapper.map(responseDto, Response.class)).willReturn(response);
        given(responseRepository.save(response)).willReturn(response);
        assertEquals(responseDto, responseService.update(responseDto, 1L));

    }

    @Test
    public void findOne1() {

        given(responseRepository.findById(1L)).willReturn(Optional.of(response));
        assertDoesNotThrow(() -> responseService.findOne(1L));

    }

    @Test
    public void findOne2() {

        given(responseRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> responseService.findOne(1L));

    }

    @Test
    public void deleteTest() {
        given(responseRepository.findById(1L)).willReturn(Optional.of(response));
        assertDoesNotThrow(() -> responseService.delete(1L));

    }

    @Test
    public void deleteTest2() {
        given(responseRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> responseService.delete(1L));
    }


    public void findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Response> responses = new ArrayList<>();
        responses.add(response);
        responses.add(response);
        responses.add(response);
        responses.add(response);
        given(responseRepository.findAll()).willReturn(responses);
        //assertEquals(4, responseService.findAll(pageable).getTotalElements());

    }

}
