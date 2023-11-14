package com.wi.quiz.DTO;

import com.wi.quiz.Entities.AssignQuiz;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String address;
    private Long id;
    private LocalDate enrollmentDate;
}
