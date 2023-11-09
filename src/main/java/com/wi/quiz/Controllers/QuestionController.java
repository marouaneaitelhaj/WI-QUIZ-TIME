package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuestionDto question) {
        try {
            return ResponseEntity.ok(questionService.save(question));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(questionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuestionDto question, @PathVariable Long id) {
        try {
            if (questionService.findById(id) == null) return ResponseEntity.badRequest().body("Question not found");
            return ResponseEntity.ok(questionService.update(question, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            if (questionService.findById(id) == null) return ResponseEntity.badRequest().body("Question not found");
            questionService.delete(id);
            return ResponseEntity.ok("Question deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/schema")
    public Question schema() {
        return new Question();
    }
}
