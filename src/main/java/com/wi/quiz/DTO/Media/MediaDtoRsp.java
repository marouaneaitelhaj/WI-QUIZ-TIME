package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.Req.QuestionDto;
import com.wi.quiz.Enums.QuestionType;
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
