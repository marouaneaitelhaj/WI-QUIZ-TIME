package com.wi.quiz.DTO.Teacher;

import com.wi.quiz.DTO.Person.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto extends PersonDto {
    private String speciality;
}
