package com.wi.quiz.DTO.Subject;

import com.wi.quiz.DTO.Question.QuestionDto;
import com.wi.quiz.DTO.Question.QuestionDtoNoRel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDtoRsp {
    private Long id;
    private String name;
    private SubjectDtoNoRel top;
    private List<SubjectDtoNoRel> subs;
    private List<QuestionDtoNoRel> questions;
}
