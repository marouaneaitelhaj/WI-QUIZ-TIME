package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.DTO.Rsp.ResponseDtoRsp;
import com.wi.quiz.Entities.Response;
import com.wi.quiz.Repositories.ResponseRepository;
import com.wi.quiz.Services.Inter.ResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseDto save(ResponseDto responseDto) {
        
            Response response = modelMapper.map(responseDto, Response.class);
            responseRepository.save(response);
            return responseDto;
        
    }

    @Override
    public ResponseDto update(ResponseDto responseDto, Long aLong) {
        
            Response response = modelMapper.map(responseDto, Response.class);
            response.setId(aLong);
            responseRepository.save(response);
            responseDto.setId(aLong);
            return responseDto;
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Response> response = responseRepository.findById(aLong);
            if (response.isEmpty()) {
                throw new RuntimeException("Response not found for id: " + aLong);
            }
            responseRepository.deleteById(aLong);
            return responseRepository.findById(aLong).isEmpty();
        
    }

    @Override
    public ResponseDtoRsp findOne(Long aLong) {
        
            Optional<Response> response = responseRepository.findById(aLong);
            if (response.isEmpty()) {
                throw new RuntimeException("Response not found for id: " + aLong);
            }
            return modelMapper.map(response.get(), ResponseDtoRsp.class);
        
    }

    @Override
    public List<ResponseDtoRsp> findAll() {
        
            List<Response> responses = responseRepository.findAll();
            return responses.stream().map(response -> modelMapper.map(response, ResponseDtoRsp.class)).toList();
        
    }
}
