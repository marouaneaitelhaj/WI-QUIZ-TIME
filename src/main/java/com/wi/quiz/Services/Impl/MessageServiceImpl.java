package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.DTO.Message.MessageDtoRsp;
import com.wi.quiz.Services.Inter.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    @Override
    public MessageDtoRsp save(MessageDto messageDto) {
        return null;
    }

    @Override
    public MessageDtoRsp update(MessageDto messageDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public MessageDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<MessageDtoRsp> findAll() {
        return null;
    }
}
