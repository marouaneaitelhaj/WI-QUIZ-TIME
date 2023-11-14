package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.AssignQuizDto;
import com.wi.quiz.Entities.AssignQuiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoRsp {
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String address;
    private Long id;
    private LocalDate enrollmentDate;
    private List<AssignQuizDto> quizzes;
}
