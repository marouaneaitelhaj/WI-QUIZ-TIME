package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.DTO.QuizDto;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Entities.Quiz;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
