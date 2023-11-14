package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.AnswerDto;
import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.DTO.ResponseDto;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Entities.Response;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
