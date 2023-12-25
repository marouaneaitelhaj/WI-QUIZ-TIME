package com.wi.quiz.DTO.QuestionOfQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDto {
    private Long id;
    private Long question_id;
    private Long quiz_id;
}
