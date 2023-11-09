package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private int successResult;
    private Boolean answerAccess;
    private Boolean resultAccess;
    private int numberOfChances;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
}