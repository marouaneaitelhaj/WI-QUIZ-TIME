package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.DTO.Rsp.QuestionDtoRsp;
import com.wi.quiz.Services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService extends BaseService<QuestionDtoRsp, QuestionDto, Long> {
}