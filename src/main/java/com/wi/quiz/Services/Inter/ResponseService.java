package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.DTO.Rsp.ResponseDtoRsp;
import com.wi.quiz.Services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResponseService extends BaseService<ResponseDtoRsp,ResponseDto, Long> {
}
