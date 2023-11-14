package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.DTO.Rsp.QuestionDtoRsp;
import com.wi.quiz.Services.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody QuestionDto question) {
        Map<String, Object> message = new HashMap<>();
        message.put("message", "Question created successfully");
        QuestionDto questionDto = questionService.save(question);
        message.put("question", questionDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionDtoRsp>> findAll() {
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody QuestionDto question, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        QuestionDto questionDto = questionService.update(question, id);
        message.put("message", "Question updated successfully");
        message.put("question", questionDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (questionService.delete(id)){
            message.put("message", "Question deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Question not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
