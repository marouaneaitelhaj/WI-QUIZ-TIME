package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.QuestionOfQuizDto;
import com.wi.quiz.DTO.QuestionOfQuizDto;
import com.wi.quiz.DTO.Rsp.QuestionOfQuizDtoRsp;
import com.wi.quiz.Services.Impl.QuestionOfQuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questionofquizDto")
public class QuestionOfQuizController {
    @Autowired
    private QuestionOfQuizServiceImpl questionOfQuizService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuestionOfQuizDto questionOfQuiz) {
        Map<String, Object> message = new HashMap<>();
        QuestionOfQuizDto questionOfQuizDto =  questionOfQuizService.save(questionOfQuiz);
        message.put("message", "Level created successfully");
        message.put("questionOfQuiz", questionOfQuizDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionOfQuizDtoRsp>> findAll() {
        return ResponseEntity.ok(questionOfQuizService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionOfQuizDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionOfQuizService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuestionOfQuizDto questionOfQuizDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        QuestionOfQuizDto questionOfQuiz = questionOfQuizService.update(questionOfQuizDto, id);
        message.put("message", "Level updated successfully");
        message.put("questionOfQuiz", questionOfQuiz);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (questionOfQuizService.delete(id)) {
            message.put("message", "Level deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Level not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
