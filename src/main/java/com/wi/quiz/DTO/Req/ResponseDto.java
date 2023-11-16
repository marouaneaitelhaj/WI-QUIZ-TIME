package com.wi.quiz.DTO;

import java.util.List;

import com.wi.quiz.Entities.Validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {
     private Long id;
    private String response;
}
