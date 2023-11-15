package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends Person {
    private LocalDate enrollmentDate;
    @OneToMany(mappedBy = "student")
    private List<AssignQuiz> quizzes;
}
