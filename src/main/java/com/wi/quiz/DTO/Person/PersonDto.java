package com.wi.quiz.DTO.Person;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PersonDto {
    protected Long id;
    protected String lastName;
    protected String firstName;
    protected LocalDate dateOfBirth;
    protected String address;
}
