package com.wi.quiz.DTO;

import com.wi.quiz.DTO.SubjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponseDto {
    private Long id;
    private String name;

    private SubjectDto top;

    private List<SubjectDto> subs;
}
