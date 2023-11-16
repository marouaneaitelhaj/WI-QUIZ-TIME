package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.AssignQuiz.AssignQuizDtoRsp;
import com.wi.quiz.Services.Impl.AssignQuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/assignquiz")
public class AssignQuizController {
    @Autowired
    private AssignQuizServiceImpl quizService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody AssignQuizDto assignQuiz) {
        Map<String, Object> message = new HashMap<>();
        AssignQuizDto assignQuizDto =  quizService.save(assignQuiz);
        message.put("message", "Assign Quiz created successfully");
        message.put("assignQuiz", assignQuizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssignQuizDtoRsp>> findAll() {
        return ResponseEntity.ok(quizService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignQuizDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AssignQuizDto assignQuizDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        AssignQuizDto assignQuiz = quizService.update(assignQuizDto, id);
        message.put("message", "Assign Quiz updated successfully");
        message.put("assignQuiz", assignQuiz);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (quizService.delete(id)) {
            message.put("message", "Assign Quiz deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Assign Quiz not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/schema")
    public AssignQuizDto getSchema() {
        return new AssignQuizDto();
    }
}
