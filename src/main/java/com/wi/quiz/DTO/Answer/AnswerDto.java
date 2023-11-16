package com.wi.quiz.DTO.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private Long id;
    private AssignQuizDto assignQuiz;
    private ValidationDto validation;
}
