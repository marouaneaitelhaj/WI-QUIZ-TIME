package com.wi.quiz.DTO.Quiz;

import com.wi.quiz.DTO.Teacher.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDtoNoRel {
    private Long id;
    private int successResult;
    private Boolean answerAccess = false;
    private Boolean resultAccess = false;
    private int numberOfChances;
    private String comment;
}
