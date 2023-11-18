package com.wi.quiz.DTO.Media;

import com.wi.quiz.Enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MediaDtoNoRel {
    private Long id;
    private String src;
    private MediaType type;
}
