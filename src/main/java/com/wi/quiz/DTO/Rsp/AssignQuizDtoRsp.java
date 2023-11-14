package com.wi.quiz.DTO.Rsp;

import com.wi.quiz.DTO.AnswerDto;
import com.wi.quiz.DTO.QuizDto;
import com.wi.quiz.DTO.StudentDto;
import com.wi.quiz.Entities.Answer;
import com.wi.quiz.Entities.Quiz;
import com.wi.quiz.Entities.Student;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignQuizDtoRsp {
    private Long id;
    private StudentDto student;
    private QuizDto quiz;
    private List<AnswerDto> answers;
    private int score;
    private int chance;
    private String notes;
    private LocalDate date;
}
