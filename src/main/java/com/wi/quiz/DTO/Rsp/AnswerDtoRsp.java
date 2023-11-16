package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.AssignQuizDto;
import com.wi.quiz.DTO.Req.ValidationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDtoRsp {
    private Long id;
    private AssignQuizDto assignQuiz;
    private ValidationDto validation;
}
