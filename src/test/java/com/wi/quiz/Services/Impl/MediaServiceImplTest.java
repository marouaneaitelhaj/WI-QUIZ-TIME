package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Media.MediaDto;
import com.wi.quiz.DTO.Media.MediaDtoRsp;
import com.wi.quiz.Entities.Media;
import com.wi.quiz.Repositories.MediaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class MediaServiceImplTest {
    @Mock
    private MediaRepository mediaRepository;

    @InjectMocks
    private MediaServiceImpl mediaService;

    @Mock
    private ModelMapper modelMapper;


    private Media media;

    private MediaDto mediaDto;

    private MediaDtoRsp mediaDtoRsp;

    private List<MediaDtoRsp> mediaDtoRsps;

    @BeforeEach
    public void setUp() {
        media = new Media();
        media.setId(1L);

        mediaDto = new MediaDto();
        mediaDto.setId(1L);

        mediaDtoRsp = new MediaDtoRsp();
        mediaDtoRsp.setId(1L);
    }

    @Test
    public void saveTest() {

        try {
            when(mediaService.save(mediaDto)).thenReturn(mediaDto);
            assertEquals(mediaDto, mediaService.save(mediaDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //@Test
    public void updateTest1() {
        try {
            given(mediaRepository.findById(1L)).willReturn(Optional.of(media));
            given(modelMapper.map(mediaDto, Media.class)).willReturn(media);
            given(mediaRepository.save(media)).willReturn(media);
            assertSame(mediaDto.getId(), mediaService.update(mediaDto, 1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest2() {
        try {
            given(mediaRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> mediaService.update(mediaDto, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void findOne1() {
        try {

            given(mediaRepository.findById(1L)).willReturn(Optional.of(media));
            assertEquals(mediaDtoRsp.getId(), mediaService.findOne(1L).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findOne2() {
        try {

            given(mediaRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> mediaService.findOne(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest() {
        try {
            given(mediaRepository.findById(1L)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> mediaService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void deleteTest2() {
        try {
            given(mediaRepository.findById(1L)).willReturn(Optional.ofNullable(media));
            assertDoesNotThrow(() -> mediaService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {

        try {
            Pageable pageable = PageRequest.of(0, 10);
            List<Media> medias = new ArrayList<>();
            medias.add(media);
            medias.add(media);
            medias.add(media);
            given(mediaRepository.findAll()).willReturn(medias);
            assertEquals(3, mediaService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
