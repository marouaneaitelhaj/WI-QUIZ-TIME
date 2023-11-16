package com.wi.quiz.DTO;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto extends Person {
    private Long id;
    private String speciality;
}
