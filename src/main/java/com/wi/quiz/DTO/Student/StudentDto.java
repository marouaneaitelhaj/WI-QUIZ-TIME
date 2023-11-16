package com.wi.quiz.DTO.Student;

import com.wi.quiz.DTO.Person.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends PersonDto {
    private LocalDate enrollmentDate;
}
