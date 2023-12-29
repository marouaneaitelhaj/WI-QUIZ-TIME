package com.wi.quiz.Services.Inter;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.DTO.Message.MessageDtoRsp;
import com.wi.quiz.Services.BaseService;

import java.util.List;

public interface MessageService  extends BaseService<MessageDtoRsp, MessageDto, Long> {
    List<MessageDtoRsp> findAll(Long room_id);
}
