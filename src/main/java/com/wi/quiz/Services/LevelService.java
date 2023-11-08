package com.wi.quiz.Services;

import com.wi.quiz.Entities.Level;

import java.util.List;

public interface LevelService {
    public Level save(Level level);

    public Level update(Level level, Long id);

    public void delete(Long id);

    public Level findById(Long id);

    public List<Level> findAll();
}
