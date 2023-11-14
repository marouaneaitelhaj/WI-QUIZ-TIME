package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.MediaDto;
import com.wi.quiz.DTO.Rsp.MediaDtoRsp;
import com.wi.quiz.Repositories.MediaRepository;
import com.wi.quiz.Services.Inter.MediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDto save(MediaDto mediaDto) {
        return null;
    }

    @Override
    public MediaDto update(MediaDto mediaDto, Long aLong) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public MediaDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<MediaDtoRsp> findAll() {
        return null;
    }
}
