package com.wi.quiz.DTO.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    private int successResult;
    private boolean answerAccess;
    private boolean resultAccess;
    private int numberOfChances;
    private String comment;
    private Long teacher_id;
}
