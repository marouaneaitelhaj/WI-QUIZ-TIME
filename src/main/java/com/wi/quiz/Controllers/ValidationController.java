package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.Services.Impl.ValidationServiceImpl;
import com.wi.quiz.Services.Inter.ValidationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/validation")
@RequiredArgsConstructor
public class ValidationController {

    private final ValidationService levelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ValidationDto validation) {
        Map<String, Object> message = new HashMap<>();
        ValidationDtoRsp validationDtoRsp =  levelService.save(validation);
        message.put("message", "Validation created successfully");
        message.put("data", validationDtoRsp);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ValidationDtoRsp>> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(levelService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidationDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ValidationDto validationDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        ValidationDtoRsp validation = levelService.update(validationDto, id);
        message.put("message", "Validation updated successfully");
        message.put("data", validation);
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
