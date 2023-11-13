package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Rsp.SubjectDtoRsp;
import com.wi.quiz.DTO.SubjectDto;
import com.wi.quiz.Services.Impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> save(@RequestBody SubjectDto subjectDto) {
        return subjectService.save(subjectDto);

    }

    @GetMapping
    public ResponseEntity<List<SubjectDtoRsp>> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDtoRsp> findById(@PathVariable Long id) {
        return subjectService.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> update(@RequestBody SubjectDto subjectDto, @PathVariable Long id) {
        return subjectService.update(subjectDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return subjectService.delete(id);
    }
}
