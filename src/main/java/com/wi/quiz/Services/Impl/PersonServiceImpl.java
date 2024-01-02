package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Person.PersonDtoLogin;
import com.wi.quiz.Repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    public boolean login(PersonDtoLogin personDtoLogin) {
        return personRepository.findByFirstNameAndLastName(personDtoLogin.getFirstName(), personDtoLogin.getLastName()).isPresent();
    }
}
