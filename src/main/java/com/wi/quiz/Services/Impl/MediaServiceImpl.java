package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Media.MediaDto;
import com.wi.quiz.DTO.Media.MediaDtoRsp;
import com.wi.quiz.Entities.Media;
import com.wi.quiz.Exceptions.DuplicateEx;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.MediaRepository;
import com.wi.quiz.Services.Inter.MediaService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    
    private final MediaRepository mediaRepository;
    
    private final ModelMapper modelMapper;




    @Override
    public MediaDto save(MediaDto mediaDto) {
        Media media = modelMapper.map(mediaDto, Media.class);
        checkIfMediaExist(mediaDto);
        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public MediaDto update(MediaDto mediaDto, Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new NotFoundEx("Media not found for id: " + aLong);
        }
        Media media = modelMapper.map(mediaDto, Media.class);
        checkIfMediaExist(mediaDto);
        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new NotFoundEx("Media not found for id: " + aLong);
        }
        mediaRepository.deleteById(aLong);
        return mediaRepository.findById(aLong).isEmpty();
    }

    @Override
    public MediaDtoRsp findOne(Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new NotFoundEx("Media not found for id: " + aLong);
        }
        Media media = optionalMedia.get();
        return modelMapper.map(media, MediaDtoRsp.class);
    }

    @Override
    public Page<MediaDtoRsp> findAll(Pageable pageable) {
        Page<Media> mediaList = mediaRepository.findAll(pageable);
        return mediaList.map(media -> modelMapper.map(media, MediaDtoRsp.class));
    }

    @Override
    public void checkIfMediaExist(MediaDto mediaDto) {
        Optional<Media> optionalMedia = mediaRepository.findBySrcAndTypeAndQuestionId(mediaDto.getSrc(), mediaDto.getType(), mediaDto.getQuestion().getId());
        if (optionalMedia.isPresent()) {
            throw new DuplicateEx("Media already exist");
        }
    }
}
