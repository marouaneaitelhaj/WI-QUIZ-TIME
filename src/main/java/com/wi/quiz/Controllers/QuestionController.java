package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.DTO.Rsp.QuestionDtoRsp;
import com.wi.quiz.Services.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping
    public ResponseEntity<QuestionDto> save(@RequestBody QuestionDto question) {
        return questionService.save(question);
    }

    @GetMapping
    public ResponseEntity<List<QuestionDtoRsp>> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDtoRsp> findById(@PathVariable Long id) {
        return questionService.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> update(@RequestBody QuestionDto question, @PathVariable Long id) {
        return questionService.update(question, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return questionService.delete(id);
    }
}
