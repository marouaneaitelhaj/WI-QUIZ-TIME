package com.wi.quiz.DTO.Student;

import com.wi.quiz.DTO.Person.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends PersonDto {
    private LocalDate enrollmentDate;
}
