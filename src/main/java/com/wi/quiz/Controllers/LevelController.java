package com.wi.quiz.Controllers;

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
    public ResponseEntity<?> save(@RequestBody Level level) {
        try {
            return ResponseEntity.ok(levelService.save(level));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<Level> levels = levelService.findAll();
            return ResponseEntity.ok(levels);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Level level = levelService.findById(id);
            return ResponseEntity.ok(level);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Level level, @PathVariable Long id) {
        try {
            if (levelService.findById(id) == null) return ResponseEntity.badRequest().body("Level not found");
            return ResponseEntity.ok(levelService.update(level, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            if (levelService.findById(id) == null) return ResponseEntity.badRequest().body("Level not found");
            levelService.delete(id);
            return ResponseEntity.ok("Level deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


}
