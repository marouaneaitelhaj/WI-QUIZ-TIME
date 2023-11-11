package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.LevelDto;
import com.wi.quiz.Entities.Level;
import com.wi.quiz.Services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LevelDto level) {
        try {
            return ResponseEntity.ok(levelService.save(level));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<LevelDto> levels = levelService.findAll();
            return ResponseEntity.ok(levels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            LevelDto level = levelService.findById(id);
            return ResponseEntity.ok(level);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody LevelDto levelDto, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(levelService.update(levelDto, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            levelService.delete(id);
            return ResponseEntity.ok("Level deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


}
