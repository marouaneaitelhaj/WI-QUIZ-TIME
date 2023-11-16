package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.PersonDto;
import com.wi.quiz.DTO.Req.QuizDtoForTeacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDtoRsp extends PersonDto {
    private String speciality;
    private List<QuizDtoForTeacher> quizzes;
}
