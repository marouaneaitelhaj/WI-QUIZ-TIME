package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Subject.SubjectDtoRsp;
import com.wi.quiz.DTO.Subject.SubjectDto;
import com.wi.quiz.Services.Impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SubjectDto subjectDto) {
        Map<String, Object> message = new HashMap<>();
        SubjectDto subject = subjectService.save(subjectDto);
        message.put("message", "Subject created successfully");
        message.put("subject", subject);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDtoRsp>> findAll() {

        return ResponseEntity.ok(subjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SubjectDto subjectDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        SubjectDto subject = subjectService.update(subjectDto, id);
        message.put("message", "Subject updated successfully");
        message.put("subject", subject);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (subjectService.delete(id)){
            message.put("message", "Subject deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Subject not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
