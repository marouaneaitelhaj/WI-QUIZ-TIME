package com.wi.quiz.DTO.Req;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Quiz;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto extends PersonDto {
    private String speciality;
}
