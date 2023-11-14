package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.LevelDto;
import com.wi.quiz.DTO.Rsp.LevelDtoRsp;
import com.wi.quiz.Services.Impl.LevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelServiceImpl levelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LevelDto level) {
        Map<String, Object> message = new HashMap<>();
        LevelDto levelDto =  levelService.save(level);
        message.put("message", "Level created successfully");
        message.put("level", levelDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LevelDtoRsp>> findAll() {
        return ResponseEntity.ok(levelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody LevelDto levelDto, @PathVariable Long id) {
            Map<String, Object> message = new HashMap<>();
            LevelDto level = levelService.update(levelDto, id);
            message.put("message", "Level updated successfully");
            message.put("level", level);
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        levelService.delete(id);
        Map<String, Object> message = new HashMap<>();
        message.put("message", "Level deleted successfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
