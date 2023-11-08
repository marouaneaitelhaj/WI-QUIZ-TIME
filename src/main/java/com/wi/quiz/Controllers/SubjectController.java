package com.wi.quiz.Controllers;

import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Subject subject) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.save(subject));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<Subject> subjects = subjectService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(subjects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Subject subject, @PathVariable Long id) {
        try {
            if (subjectService.findById(id) == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Subject not found");
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.update(subject, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            if (subjectService.findById(id) == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Subject not found");
            subjectService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Subject deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
