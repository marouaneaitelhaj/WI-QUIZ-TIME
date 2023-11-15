package com.wi.quiz.DTO;

import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Entities.Student;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
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
