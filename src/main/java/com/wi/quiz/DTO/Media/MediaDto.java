package com.wi.quiz.DTO.Media;

import com.wi.quiz.Enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MediaDto {
    private Long id;
    private String src;
    private MediaType type;
    private Long question_id;
}
