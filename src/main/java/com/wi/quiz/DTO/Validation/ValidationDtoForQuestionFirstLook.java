package com.wi.quiz.DTO.Validation;

import com.wi.quiz.DTO.Response.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationDtoForQuestionFirstLook {
    private Long id;
    private ResponseDto response;
}
