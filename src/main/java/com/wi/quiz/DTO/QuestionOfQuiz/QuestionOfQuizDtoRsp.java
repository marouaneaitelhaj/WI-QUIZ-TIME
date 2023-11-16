package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.QuestionDto;
import com.wi.quiz.DTO.Req.QuizDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDtoRsp {
    private Long id;
    private QuestionDto question;
    private QuizDto quiz;
}
