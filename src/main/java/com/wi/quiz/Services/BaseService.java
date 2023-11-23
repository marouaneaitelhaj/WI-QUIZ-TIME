package com.wi.quiz.Services;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Map;

public interface BaseService<DTO_RSP, DTO_MINI, F> {
    DTO_MINI save(DTO_MINI dtoMini);

    DTO_MINI update(DTO_MINI dtoMini, F f);

    Boolean delete(F f);

    DTO_RSP findOne(F f);

    Page<DTO_RSP> findAll(Pageable pageable);
}