package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.AssignQuiz.AssignQuizDto;
import com.wi.quiz.DTO.Req.QuestionOfQuizDto;
import com.wi.quiz.DTO.Req.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDtoRsp {
    private Long id;
    private int successResult;
    private Boolean answerAccess = false;
    private Boolean resultAccess = false;
    private int numberOfChances;
    private String comment;
    private TeacherDto teacher;
    private List<QuestionOfQuizDto> questionOfQuizs;
    private List<AssignQuizDto> assignQuizs;
}
