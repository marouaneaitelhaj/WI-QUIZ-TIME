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
public class Validation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Response response;
    @OneToMany(mappedBy = "validation", cascade = CascadeType.ALL)
    private List<Answer> answers;
    private boolean isCorrect;
    private int points;
}