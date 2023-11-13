package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.LevelDto;
import com.wi.quiz.DTO.Rsp.LevelDtoRsp;
import com.wi.quiz.Services.Impl.LevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelServiceImpl levelService;

    @PostMapping
    public void save(@RequestBody LevelDto level) {
            levelService.save(level);
    }

    @GetMapping
    public ResponseEntity<List<LevelDtoRsp>> findAll() {
        return levelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelDtoRsp> findById(@PathVariable Long id) {
        return levelService.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LevelDto> update(@RequestBody LevelDto levelDto, @PathVariable Long id) {
            return levelService.update(levelDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return levelService.delete(id);
    }


}
