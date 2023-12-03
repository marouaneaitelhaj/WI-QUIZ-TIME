package com.wi.quiz.DTO.Question;

import com.wi.quiz.DTO.Media.MediaDtoNoRel;
import com.wi.quiz.Enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDtoNoRel {
    private Long id;
    private String question;
    private int numberOfAnswers;
    private int numberOfCorrectAnswers;
    private QuestionType questionType;
    private int points;
    private int time;
    private List<MediaDtoNoRel> media;
}