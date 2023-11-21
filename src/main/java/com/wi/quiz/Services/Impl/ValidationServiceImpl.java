package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Validation.ValidationDtoRsp;
import com.wi.quiz.DTO.Validation.ValidationDto;
import com.wi.quiz.Entities.Validation;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.ValidationRepository;
import com.wi.quiz.Services.Inter.ValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ValidationDto save(ValidationDto validationDto) {
        Validation validation = modelMapper.map(validationDto, Validation.class);
        checkIfExist(validation.getQuestion().getId(), validation.getResponse().getId());
        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDto.class);
    }

    @Override
    public ValidationDto update(ValidationDto validationDto, Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new NotFoundEx("Validation not found for id: " + aLong);
        }
        Validation validation = modelMapper.map(validationDto, Validation.class);
        checkIfExist(validation.getQuestion().getId(), validation.getResponse().getId());
        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDto.class);
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
    public Page<ValidationDtoRsp> findAll(Pageable pageable) {
        Page<Validation> validations = validationRepository.findAll(pageable);
        return validations.map(validation -> modelMapper.map(validation, ValidationDtoRsp.class));
    }

    @Override
    public void checkIfExist(Long question, Long response) {
        validationRepository.findByQuestionIdAndResponseId(question, response).ifPresent(validationDtoRsp -> {
            throw new NotFoundEx("Validation already exist for question: " + question + " and response: " + response);
        });
    }
}
