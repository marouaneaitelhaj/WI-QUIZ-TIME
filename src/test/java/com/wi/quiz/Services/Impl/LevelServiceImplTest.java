package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Level.LevelDto;
import com.wi.quiz.DTO.Level.LevelDtoRsp;
import com.wi.quiz.Entities.Level;
import com.wi.quiz.Repositories.LevelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LevelServiceImplTest {
    @Mock
    private LevelRepository levelRepository;

    @InjectMocks
    private LevelServiceImpl levelService;

    @Mock
    private ModelMapper modelMapper;


    private Level level;

    private LevelDto levelDto;

    private LevelDtoRsp levelDtoRsp;

    private List<LevelDtoRsp> levelDtoRsps;

    @BeforeEach
    public void setUp() {
        level = new Level();
        level.setId(1L);
        level.setDescription("response");

        levelDto = new LevelDto();
        levelDto.setId(1L);
        levelDto.setDescription("response");

        levelDtoRsp = new LevelDtoRsp();
        levelDtoRsp.setId(1L);
        levelDtoRsp.setDescription("response");

    }

    @Test
    public void saveTest() {
        try {
            when(levelService.save(levelDto)).thenReturn(levelDto);
            assertEquals(levelDto, levelService.save(levelDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest1() {
        try {
            given(levelRepository.findById(1L)).willReturn(Optional.of(level));
            given(modelMapper.map(levelDto, Level.class)).willReturn(level);
            given(levelRepository.save(level)).willReturn(level);
            assertEquals(levelDto.getDescription(), levelService.update(levelDto, 1L).getDescription());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateTest2() {
        given(levelRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> levelService.update(levelDto, 1L));
    }

    @Test
    public void findOne1() {
        given(levelRepository.findById(1L)).willReturn(Optional.ofNullable(level));
        given(levelService.findOne(1L)).willReturn(levelDtoRsp);
        assertEquals(levelDtoRsp, levelService.findOne(1L));
    }

    @Test
    public void findOne2() {

        given(levelRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> levelService.findOne(1L));

    }

    @Test
    public void deleteTest() {
        try {
            given(levelRepository.findById(1L)).willReturn(Optional.ofNullable(level));
            when(levelService.delete(1L)).thenReturn(true);
            assertEquals(true, levelService.delete(1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteTest2() {

        given(levelRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> levelService.delete(1L));

    }

    @Test
    public void findAll() {
        try {
            List<Level> levels = new ArrayList<>();
            levels.add(level);
            levels.add(level);
            levels.add(level);
            given(levelRepository.findAll()).willReturn(levels);
            assertEquals(levels.size(), levelService.findAll().size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}


