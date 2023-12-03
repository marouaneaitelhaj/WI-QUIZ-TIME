package com.wi.quiz.DTO.QuestionOfQuiz;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoNoRel;
import com.wi.quiz.DTO.Quiz.QuizDto;
import com.wi.quiz.DTO.Quiz.QuizDtoNoRel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOfQuizDtoNoRelForQuestions {
    private Long id;
    //private QuestionDtoNoRel question;
    private QuizDtoNoRel quiz;
}
