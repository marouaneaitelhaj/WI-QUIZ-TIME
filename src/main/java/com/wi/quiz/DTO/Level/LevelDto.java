package com.wi.quiz.DTO.Req;

import com.wi.quiz.Entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDto {
    private Long id;
    private String description;
    private int maxPoints;
    private int minPoints;
}
