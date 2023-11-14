package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.QuestionDto;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Enums.QuestionType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MediaDtoRsp {
    private Long id;
    private String src;
    private QuestionType type;
    private QuestionDto question;
}
