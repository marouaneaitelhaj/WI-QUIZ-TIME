package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.MediaDto;
import com.wi.quiz.DTO.Rsp.MediaDtoRsp;
import com.wi.quiz.Entities.Media;
import com.wi.quiz.Repositories.MediaRepository;
import com.wi.quiz.Services.Inter.MediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDto save(MediaDto mediaDto) {
        Media media = modelMapper.map(mediaDto, Media.class);
        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public MediaDto update(MediaDto mediaDto, Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new RuntimeException("Media not found for id: " + aLong);
        }
        Media media = modelMapper.map(mediaDto, Media.class);
        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new RuntimeException("Media not found for id: " + aLong);
        }
        mediaRepository.deleteById(aLong);
        return mediaRepository.findById(aLong).isEmpty();
    }

    @Override
    public MediaDtoRsp findOne(Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new RuntimeException("Media not found for id: " + aLong);
        }
        Media media = optionalMedia.get();
        return modelMapper.map(media, MediaDtoRsp.class);
    }

    @Override
    public List<MediaDtoRsp> findAll() {
        List<Media> mediaList = mediaRepository.findAll();
        return mediaList.stream().map(media -> modelMapper.map(media, MediaDtoRsp.class)).toList();
    }
}
