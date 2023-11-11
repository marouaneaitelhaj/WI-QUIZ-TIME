package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.LevelDto;
import com.wi.quiz.Entities.Level;
import com.wi.quiz.Repositories.LevelRepository;
import com.wi.quiz.Services.LevelService;
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
    public LevelDto save(LevelDto level) throws Exception {
        try {
            return modelMapper.map(levelRepository.save(modelMapper.map(level, Level.class)), LevelDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public LevelDto update(LevelDto levelDto, Long id) throws Exception {
        try {
            Optional<Level> optionalLevel = levelRepository.findById(id);
            if (optionalLevel.isPresent()) {
                Level level = modelMapper.map(levelDto, Level.class);
                level.setId(id);
                levelRepository.save(level);
                return levelDto;
            } else {
                throw new Exception("Level not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<Level> level = levelRepository.findById(id);
            if (level.isPresent()) {
                levelRepository.deleteById(id);
            } else {
                throw new Exception("Level not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public LevelDto findById(Long id) throws Exception {
        try {
            Optional<Level> level = levelRepository.findById(id);
            if (level.isPresent()) {
                return modelMapper.map(level.get(), LevelDto.class);
            } else {
                throw new Exception("Level not found for id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<LevelDto> findAll() throws Exception {
        try {
            List<Level> levels = levelRepository.findAll();
            return levels.stream().map(level -> modelMapper.map(level, LevelDto.class)).toList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
