package com.wi.quiz.DTO.Teacher;

import com.wi.quiz.DTO.Person.PersonDto;
import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Quiz.QuizDtoNoRel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDtoRsp extends PersonDto {
    private String speciality;
    private List<QuizDtoNoRel> quizzes;
}
