package com.wi.quiz.DTO.Validation;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Response.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationDtoForQuestion {
    private Long id;
    private ResponseDto response;
    private boolean isCorrect;
    private int points;
}
