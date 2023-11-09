package com.wi.quiz.DTO;

import com.wi.quiz.Entities.Level;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Enums.QuestionType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDto {
    private Long id;
    private String question;
    private QuestionType questionType;
    private int points;
    private LevelDto level;
    private SubjectDto subject;
}
