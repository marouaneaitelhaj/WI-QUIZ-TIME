package com.wi.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDto {
    private Long id;
    private QuestionDto question;
    private QuizDto quiz;
}
