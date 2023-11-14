package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.AssignQuizDto;
import com.wi.quiz.DTO.ValidationDto;
import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Entities.Validation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
