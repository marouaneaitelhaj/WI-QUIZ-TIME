package com.wi.quiz.DTO;

import com.wi.quiz.Entities.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String address;
    private Long id;
    private String speciality;
}
