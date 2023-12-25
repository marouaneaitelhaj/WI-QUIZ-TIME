package com.wi.quiz.DTO.AssignQuiz;

import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Student.StudentDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDto {

    private Long id;
    @NotNull
    private Long student;
    @NotNull
    private Long quiz;
    @NotNull
    private int score;
    @NotNull
    private int chance;
    @NotNull
    private String notes;
    private LocalDate date = LocalDate.now();
    private boolean played;
}
