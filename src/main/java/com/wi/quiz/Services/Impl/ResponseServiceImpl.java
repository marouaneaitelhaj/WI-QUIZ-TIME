package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.Entities.Response;
import com.wi.quiz.Repositories.ResponseRepository;
import com.wi.quiz.Services.ResponseService;
import org.aspectj.apache.bcel.classfile.Module;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseDto save(ResponseDto responseDto) throws Exception {
        try {
            Response response = modelMapper.map(responseDto, Response.class);
            responseRepository.save(response);
            return responseDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ResponseDto update(ResponseDto responseDto, Long id) throws Exception {
        try {
            Optional<Response> optionalResponse = responseRepository.findById(id);
            if (optionalResponse.isPresent()) {
                Response response = modelMapper.map(responseDto, Response.class);
                response.setId(id);
                responseRepository.save(response);
                return responseDto;
            } else {
                throw new Exception("Response not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<Response> response = responseRepository.findById(id);
            if (response.isPresent()) {
                responseRepository.deleteById(id);
            } else {
                throw new Exception("Response not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ResponseDto findById(Long id) throws Exception {
        try {
            Optional<Response> response = responseRepository.findById(id);
            if (response.isPresent()) {
                return modelMapper.map(response.get(), ResponseDto.class);
            } else {
                throw new Exception("Response not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ResponseDto> findAll() throws Exception {
        try {
            List<Response> responses = responseRepository.findAll();
            return responses.stream().map(response -> modelMapper.map(response, ResponseDto.class)).toList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
