package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Quiz;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDtoRsp extends Person {
    private Long id;
    private String speciality;
    private List<Quiz> quizzes;
}
