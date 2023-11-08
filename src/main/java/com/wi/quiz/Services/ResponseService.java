package com.wi.quiz.Services;

import com.wi.quiz.Entities.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResponseService {

    public Response save(Response response);

    public Response update(Response response, Long id);

    public void delete(Long id);

    public Response findById(Long id);

    public List<Response> findAll();
}
