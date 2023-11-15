package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.ValidationDto;
import com.wi.quiz.DTO.Rsp.ValidationDtoRsp;
import com.wi.quiz.Services.Impl.LevelServiceImpl;
import com.wi.quiz.Services.Impl.ValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/validation")
public class ValidationController {
    @Autowired
    private ValidationServiceImpl levelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ValidationDto validation) {
        Map<String, Object> message = new HashMap<>();
        ValidationDto validationDto =  levelService.save(validation);
        message.put("message", "Validation created successfully");
        message.put("validation", validationDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ValidationDtoRsp>> findAll() {
        return ResponseEntity.ok(levelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidationDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ValidationDto validationDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        ValidationDto validation = levelService.update(validationDto, id);
        message.put("message", "Validation updated successfully");
        message.put("validation", validation);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (levelService.delete(id)) {
            message.put("message", "Validation deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Validation not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}