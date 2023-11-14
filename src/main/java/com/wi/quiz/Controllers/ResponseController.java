package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.DTO.Rsp.ResponseDtoRsp;
import com.wi.quiz.Services.Impl.ResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/response")
public class ResponseController {
    @Autowired
    private ResponseServiceImpl responseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ResponseDto response) {
        Map<String, Object> message = new HashMap<>();
        ResponseDto responseDto = responseService.save(response);
        message.put("message", "Response created successfully");
        message.put("response", responseDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDtoRsp>> findAll() {
        return ResponseEntity.ok(responseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(responseService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ResponseDto response, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        ResponseDto responseDto = responseService.update(response, id);
        message.put("message", "Response updated successfully");
        message.put("response", responseDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (responseService.delete(id)){
            message.put("message", "Response deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Response not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
