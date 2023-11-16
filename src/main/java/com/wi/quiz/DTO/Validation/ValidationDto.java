package com.wi.quiz.DTO.Validation;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Response.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ValidationDto {
    private Long id;
    private QuestionDto question;
    private ResponseDto response;
    private boolean isCorrect;
    private int points;
}
