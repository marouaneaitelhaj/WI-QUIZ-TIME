package com.wi.quiz.Services;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseService<DTO_RSP, DTO_MINI, F> {
    ResponseEntity<DTO_MINI> save(DTO_MINI dtoMini);

    ResponseEntity<DTO_MINI> update(DTO_MINI dtoMini, F f);

    ResponseEntity<String> delete(F f);

    ResponseEntity<DTO_RSP> findOne(F f);

    ResponseEntity<List<DTO_RSP>> findAll();
}
