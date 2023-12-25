package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.Entities.Validation;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.ValidationRepository;
import com.wi.quiz.Services.Inter.ValidationService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {
    
    private final ValidationRepository validationRepository;
    
    private final ModelMapper modelMapper;

    @Override
    public ValidationDtoRsp save(ValidationDto validationDto) {
        Validation validation = modelMapper.map(validationDto, Validation.class);
        checkIfExist(validation.getQuestion().getId(), validation.getResponse().getId());
        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDtoRsp.class);
    }

    @Override
    public ValidationDtoRsp update(ValidationDto validationDto, Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new NotFoundEx("Validation not found for id: " + aLong);
        }
        Validation validation = modelMapper.map(validationDto, Validation.class);
        //checkIfExist(validation.getQuestion().getId(), validation.getResponse().getId());
        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new NotFoundEx("Validation not found for id: " + aLong);
        }
        validationRepository.deleteById(aLong);
        return validationRepository.findById(aLong).isEmpty();
    }

    @Override
    public ValidationDtoRsp findOne(Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new NotFoundEx("Validation not found for id: " + aLong);
        }
        Validation validation = optionalValidation.get();
        return modelMapper.map(validation, ValidationDtoRsp.class);
    }

    @Override
    public List<ValidationDtoRsp> findAll() {
        List<Validation> validations = validationRepository.findAll();
        return validations.stream().map(validation -> modelMapper.map(validation, ValidationDtoRsp.class)).toList();
    }

    @Override
    public void checkIfExist(Long question, Long response) {
        validationRepository.findByQuestionIdAndResponseId(question, response).ifPresent(validationDtoRsp -> {
            throw new NotFoundEx("Validation already exist for question: " + question + " and response: " + response);
        });
    }
}
