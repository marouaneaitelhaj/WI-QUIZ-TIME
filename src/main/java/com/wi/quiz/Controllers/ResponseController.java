package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.DTO.Rsp.ResponseDtoRsp;
import com.wi.quiz.Services.Impl.ResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {
    @Autowired
    private ResponseServiceImpl responseService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody ResponseDto response) {
        return responseService.save(response);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDtoRsp>> findAll() {
        return responseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDtoRsp> findById(@PathVariable Long id) {
        return responseService.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@RequestBody ResponseDto response, @PathVariable Long id) {
        return responseService.update(response, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return responseService.delete(id);
    }

}
