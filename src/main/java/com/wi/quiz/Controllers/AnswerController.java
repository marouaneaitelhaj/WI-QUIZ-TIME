package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Answer.AnswerDto;
import com.wi.quiz.DTO.Answer.AnswerDtoRsp;
import com.wi.quiz.Services.Impl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody AnswerDto quiz) {
        Map<String, Object> message = new HashMap<>();
        AnswerDto quizDto = answerService.save(quiz);
        message.put("message", "Answer created successfully");
        message.put("quiz", quizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnswerDtoRsp>> findAll() {
        return ResponseEntity.ok(answerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody AnswerDto quiz, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        AnswerDto quizDto = answerService.update(quiz, id);
        message.put("message", "Answer updated successfully");
        message.put("quiz", quizDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (answerService.delete(id)){
            message.put("message", "Answer deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Answer not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
