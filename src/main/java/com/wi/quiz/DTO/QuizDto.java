package com.wi.quiz.DTO;

import com.wi.quiz.Entities.AssignQuiz;
import com.wi.quiz.Entities.QuestionOfQuiz;
import com.wi.quiz.Entities.Teacher;
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
    private Boolean answerAccess;
    private Boolean resultAccess;
    private int numberOfChances;
    private String comment;
    private TeacherDto teacher;
}
