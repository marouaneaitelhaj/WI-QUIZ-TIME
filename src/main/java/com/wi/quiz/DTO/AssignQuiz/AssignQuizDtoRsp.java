package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.AnswerDto;
import com.wi.quiz.DTO.Req.QuizDto;
import com.wi.quiz.DTO.Req.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDtoRsp {
    private Long id;
    private StudentDto student;
    private QuizDto quiz;
    private int score;
    private int chance;
    private String notes;
    private LocalDate date;
    private List<AnswerDto> answers;
}
