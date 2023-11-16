package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.AnswerDto;
import com.wi.quiz.DTO.Req.QuestionDto;
import com.wi.quiz.DTO.Req.ResponseDto;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Entities.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ValidationDtoRsp {
    private Long id;
    private QuestionDto question;
    private ResponseDto response;
    private List<AnswerDto> answers;
    private boolean isCorrect;
    private int points;
}
