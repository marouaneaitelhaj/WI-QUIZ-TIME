package com.wi.quiz.DTO.AssignQuiz;

import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDtoNoRel {
    private Long id;
    private int score;
    private int chance;
    private String notes;
    private LocalDate date;
}
