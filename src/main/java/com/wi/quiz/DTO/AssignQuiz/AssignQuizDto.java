package com.wi.quiz.DTO.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDto {
    private Long id;
    private StudentDto student;
    private QuizDto quiz;
    private int score;
    private int chance;
    private String notes;
    private LocalDate date;
}
