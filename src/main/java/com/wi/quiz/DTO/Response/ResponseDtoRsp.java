package com.wi.quiz.DTO.Rsp;

import java.util.List;

import com.wi.quiz.DTO.Req.ValidationDto;
import com.wi.quiz.Entities.Validation;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDtoRsp {
    private Long id;
    private String response;

    List<ValidationDto> validations;
}
