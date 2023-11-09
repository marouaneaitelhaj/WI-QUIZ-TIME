package com.wi.quiz.Services;

import com.wi.quiz.DTO.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResponseService {

    public ResponseDto save(ResponseDto responseDto) throws Exception;

    public ResponseDto update(ResponseDto responseDto, Long id) throws Exception;

    public void delete(Long id) throws Exception;

    public ResponseDto findById(Long id) throws Exception;

    public List<ResponseDto> findAll() throws Exception;
}
