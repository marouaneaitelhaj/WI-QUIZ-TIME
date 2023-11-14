package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.QuizDto;
import com.wi.quiz.DTO.Rsp.QuizDtoRsp;
import com.wi.quiz.Services.Impl.QuizServiceImpl;
import com.wi.quiz.Services.Inter.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizServiceImpl quizService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuizDto quiz) {
        Map<String, Object> message = new HashMap<>();
        QuizDto quizDto = quizService.save(quiz);
        message.put("message", "Quiz created successfully");
        message.put("quiz", quizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizDtoRsp>> findAll() {
        return ResponseEntity.ok(quizService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuizDto quiz, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        QuizDto quizDto = quizService.update(quiz, id);
        message.put("message", "Quiz updated successfully");
        message.put("quiz", quizDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (quizService.delete(id)){
            message.put("message", "Quiz deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Quiz not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
