package com.wi.quiz.DTO.Req;

import com.wi.quiz.Enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MediaDto {
    private Long id;
    private String src;
    private QuestionType type;
    private QuestionDto question;
}
