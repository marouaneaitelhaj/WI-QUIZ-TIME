package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Level.LevelDto;
import com.wi.quiz.DTO.Level.LevelDtoRsp;
import com.wi.quiz.Entities.Level;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.LevelRepository;
import com.wi.quiz.Services.Inter.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LevelDto save(LevelDto levelDto) {
        
            Level level = modelMapper.map(levelDto, Level.class);
            levelRepository.save(level);
            return levelDto;
        
    }

    @Override
    public LevelDto update(LevelDto levelDto, Long aLong) {
        
            Optional<Level> optionalLevel = levelRepository.findById(aLong);
            if (optionalLevel.isPresent()) {
                Level level = modelMapper.map(levelDto, Level.class);
                level.setId(aLong);
                levelRepository.save(level);
                levelDto.setId(aLong);
                return levelDto;
            } else {
                throw new NotFoundEx("Level not found for id: " + aLong);
            }
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Level> level = levelRepository.findById(aLong);
            if (level.isPresent()) {
                levelRepository.deleteById(aLong);
                Optional<Level> level1 = levelRepository.findById(aLong);
                return level1.isEmpty();
            } else {
                throw new NotFoundEx("Level not found for id: " + aLong);
            }
        
    }

    @Override
    public LevelDtoRsp findOne(Long aLong) {
            Optional<Level> optionalLevel = levelRepository.findById(aLong);
            if (optionalLevel.isPresent()) {
                return modelMapper.map(optionalLevel.get(), LevelDtoRsp.class);
            } else {
                throw new NotFoundEx("Level not found for id: " + aLong);
            }
    }

    @Override
    public List<LevelDtoRsp> findAll() {
            List<Level> levels = levelRepository.findAll();
            return levels.stream().map(level -> modelMapper.map(level, LevelDtoRsp.class)).toList();
    }
}
