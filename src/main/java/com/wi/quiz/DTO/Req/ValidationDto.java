package com.wi.quiz.DTO.Req;

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
public class ValidationDto {
    private Long id;
    private Question question;
    private Response response;
    private boolean isCorrect;
    private int points;
}
