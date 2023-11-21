package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Student.StudentDto;
import com.wi.quiz.DTO.Student.StudentDtoRsp;
import com.wi.quiz.Services.Impl.StudentServiceImpl;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto student) {
        Map<String, Object> message = new HashMap<>();
        StudentDto studentDto =  studentService.save(student);
        message.put("message", "Student created successfully");
        message.put("student", studentDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDtoRsp>> findAll(@RequestParam(defaultValue = "0") int  page, @RequestParam(defaultValue = "10") int  size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(studentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody StudentDto studentDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        StudentDto student = studentService.update(studentDto, id);
        message.put("message", "Student updated successfully");
        message.put("student", student);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (studentService.delete(id)) {
            message.put("message", "Student deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Student not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
