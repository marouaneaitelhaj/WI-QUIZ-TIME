package com.wi.quiz.DTO.Req;

import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Entities.Person;
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
public class StudentDto extends PersonDto {
    private LocalDate enrollmentDate;
}
