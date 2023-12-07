package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoRsp;
import com.wi.quiz.Services.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        message.put("data", questionDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<QuestionDtoRsp>> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(questionService.findAll(pageable));
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
        message.put("data", questionDto);
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
