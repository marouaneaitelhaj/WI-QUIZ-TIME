package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Level.LevelDto;
import com.wi.quiz.DTO.Req.MediaDto;
import com.wi.quiz.DTO.Req.QuestionOfQuizDto;
import com.wi.quiz.DTO.Req.SubjectDto;
import com.wi.quiz.DTO.Req.ValidationDto;
import com.wi.quiz.Enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoRsp {
    private Long id;
    private String question;
    private int numberOfAnswers;
    private int numberOfCorrectAnswers;
    private QuestionType questionType;
    private int points;
    private int time;
    private LevelDto level;
    private SubjectDto subject;
    private List<ValidationDto> validations;
    private List<MediaDto> media;
    private List<QuestionOfQuizDto> questionOfQuizs;
}
