package com.wi.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRespDto {
    private Long id;
    private String name;

    private SubjectDto top;

    private List<SubjectDto> subs;
}
