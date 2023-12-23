package com.wi.quiz.DTO.Answer;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.Validation.ValidationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AnswerDto {
    private Long id;
    private AssignQuizDto assignQuiz;
    private ValidationDto validation;
}
