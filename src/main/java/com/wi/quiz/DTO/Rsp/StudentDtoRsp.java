package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.AssignQuizDto;
import com.wi.quiz.DTO.Req.PersonDto;
import com.wi.quiz.Entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoRsp extends PersonDto {
    private LocalDate enrollmentDate;
    private List<AssignQuizDto> quizzes;
}
