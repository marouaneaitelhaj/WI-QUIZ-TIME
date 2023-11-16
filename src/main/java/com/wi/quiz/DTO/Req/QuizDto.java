package com.wi.quiz.DTO.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    private int successResult;
    private Boolean answerAccess = false;
    private Boolean resultAccess = false;
    private int numberOfChances;
    private String comment;
    private TeacherDto teacher;
}
