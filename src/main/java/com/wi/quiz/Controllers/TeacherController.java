package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Req.TeacherDto;
import com.wi.quiz.DTO.Rsp.TeacherDtoRsp;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Services.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TeacherDto teacher) {
        Map<String, Object> message = new HashMap<>();
        TeacherDto teacherDto =  teacherService.save(teacher);
        message.put("message", "Teacher created successfully");
        message.put("teacher", teacherDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDtoRsp>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TeacherDto teacherDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        TeacherDto teacher = teacherService.update(teacherDto, id);
        message.put("message", "Teacher updated successfully");
        message.put("teacher", teacher);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (teacherService.delete(id)) {
            message.put("message", "Teacher deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Teacher not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/test")
    public Teacher huuh() {
        Teacher student = new Teacher();
        student.setDateOfBirth(LocalDate.now());
        return student;
    }
}
