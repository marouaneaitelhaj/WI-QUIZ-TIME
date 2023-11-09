package com.wi.quiz.Services;

import com.wi.quiz.DTO.LevelDto;
import com.wi.quiz.Entities.Level;

import java.util.List;

public interface LevelService {
    public LevelDto save(Level level) throws Exception;

    public LevelDto update(LevelDto levelDto, Long id) throws Exception;

    public void delete(Long id) throws Exception;

    public LevelDto findById(Long id) throws Exception;

    public List<LevelDto> findAll() throws Exception;
}
