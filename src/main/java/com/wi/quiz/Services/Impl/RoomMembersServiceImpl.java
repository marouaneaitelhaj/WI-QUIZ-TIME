package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.RoomMembers.RoomMembersDto;
import com.wi.quiz.DTO.RoomMembers.RoomMembersDtoRsp;
import com.wi.quiz.Services.Inter.RoomMembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomMembersServiceImpl implements RoomMembersService {
    @Override
    public RoomMembersDtoRsp save(RoomMembersDto roomMembersDto) {
        return null;
    }

    @Override
    public RoomMembersDtoRsp update(RoomMembersDto roomMembersDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public RoomMembersDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<RoomMembersDtoRsp> findAll() {
        return null;
    }
}
