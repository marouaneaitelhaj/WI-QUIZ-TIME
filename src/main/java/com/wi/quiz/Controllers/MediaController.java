package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.MediaDto;
import com.wi.quiz.DTO.MediaDto;
import com.wi.quiz.DTO.Rsp.MediaDtoRsp;
import com.wi.quiz.Services.Impl.MediaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/media")
public class MediaController {
    @Autowired
    private MediaServiceImpl mediaService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody MediaDto media) {
        Map<String, Object> message = new HashMap<>();
        MediaDto mediaDto =  mediaService.save(media);
        message.put("message", "Media created successfully");
        message.put("media", mediaDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MediaDtoRsp>> findAll() {
        return ResponseEntity.ok(mediaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDtoRsp> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mediaService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody MediaDto mediaDto, @PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        MediaDto media = mediaService.update(mediaDto, id);
        message.put("message", "Media updated successfully");
        message.put("media", media);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> message = new HashMap<>();
        if (mediaService.delete(id)) {
            message.put("message", "Media deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Media not deleted");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
