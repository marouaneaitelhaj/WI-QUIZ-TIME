package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.DTO.Rsp.ResponseDtoRsp;
import com.wi.quiz.Entities.Response;
import com.wi.quiz.Repositories.ResponseRepository;
import com.wi.quiz.Services.Inter.ResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseEntity<ResponseDto> save(ResponseDto responseDto) {
        try {
            Response response = modelMapper.map(responseDto, Response.class);
            responseRepository.save(response);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDto> update(ResponseDto responseDto, Long aLong) {
        try {
            Response response = modelMapper.map(responseDto, Response.class);
            response.setId(aLong);
            responseRepository.save(response);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> delete(Long aLong) {
        try {
            responseRepository.deleteById(aLong);
            return ResponseEntity.ok("Response deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDtoRsp> findOne(Long aLong) {
        try {
            Optional<Response> response = responseRepository.findById(aLong);
            if (response.isEmpty()) {
                throw new RuntimeException("Response not found for id: " + aLong);
            }
            ResponseDtoRsp responseDtoRsp = modelMapper.map(response.get(), ResponseDtoRsp.class);
            return ResponseEntity.ok(responseDtoRsp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<ResponseDtoRsp>> findAll() {
        try {
            List<Response> responses = responseRepository.findAll();
            List<ResponseDtoRsp> responseDtoRsps = responses.stream().map(response -> modelMapper.map(response, ResponseDtoRsp.class)).toList();
            return ResponseEntity.ok(responseDtoRsps);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
