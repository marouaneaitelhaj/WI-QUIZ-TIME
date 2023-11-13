package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.LevelDto;
import com.wi.quiz.DTO.Rsp.LevelDtoRsp;
import com.wi.quiz.Entities.Level;
import com.wi.quiz.Repositories.LevelRepository;
import com.wi.quiz.Services.Inter.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<LevelDto> save(LevelDto levelDto) {
        try {
            Level level = modelMapper.map(levelDto, Level.class);
            levelRepository.save(level);
            return ResponseEntity.ok(levelDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<LevelDto> update(LevelDto levelDto, Long aLong) {
        try {
            Optional<Level> optionalLevel = levelRepository.findById(aLong);
            if (optionalLevel.isPresent()) {
                Level level = modelMapper.map(levelDto, Level.class);
                level.setId(aLong);
                levelRepository.save(level);
                return ResponseEntity.ok(levelDto);
            } else {
                throw new RuntimeException("Level not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> delete(Long aLong) {
        try {
            Optional<Level> level = levelRepository.findById(aLong);
            if (level.isPresent()) {
                levelRepository.deleteById(aLong);
                return ResponseEntity.ok("Level deleted successfully");
            } else {
                throw new RuntimeException("Level not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<LevelDtoRsp> findOne(Long aLong) {
        try {
            Optional<Level> optionalLevel = levelRepository.findById(aLong);
            if (optionalLevel.isPresent()) {
                return ResponseEntity.ok(modelMapper.map(optionalLevel.get(), LevelDtoRsp.class));
            } else {
                throw new RuntimeException("Level not found for id: " + aLong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<LevelDtoRsp>> findAll() {
        try {
            List<Level> levels = levelRepository.findAll();
            return ResponseEntity.ok(levels.stream().map(level -> modelMapper.map(level, LevelDtoRsp.class)).toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
