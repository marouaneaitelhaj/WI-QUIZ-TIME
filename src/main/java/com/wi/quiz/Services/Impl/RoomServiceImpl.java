package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Room.RoomDto;
import com.wi.quiz.DTO.Room.RoomDtoRsp;
import com.wi.quiz.Services.Inter.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    @Override
    public RoomDtoRsp save(RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDtoRsp update(RoomDto roomDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public RoomDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<RoomDtoRsp> findAll() {
        return null;
    }
}
