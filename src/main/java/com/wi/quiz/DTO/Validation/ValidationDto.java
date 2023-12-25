package com.wi.quiz.DTO.Validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ValidationDto {
    private Long id;
    private Long question_id;
    private Long response_id;
    private boolean isCorrect;
    private int points;
}
