package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Rsp.ValidationDtoRsp;
import com.wi.quiz.DTO.Req.ValidationDto;
import com.wi.quiz.Entities.Validation;
import com.wi.quiz.Repositories.ValidationRepository;
import com.wi.quiz.Services.Inter.ValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDto.class);
    }

    @Override
    public ValidationDto update(ValidationDto validationDto, Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new RuntimeException("Validation not found for id: " + aLong);
        }
        Validation validation = modelMapper.map(validationDto, Validation.class);
        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDto.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new RuntimeException("Validation not found for id: " + aLong);
        }
        validationRepository.deleteById(aLong);
        return validationRepository.findById(aLong).isEmpty();
    }

    @Override
    public ValidationDtoRsp findOne(Long aLong) {
        Optional<Validation> optionalValidation = validationRepository.findById(aLong);
        if (optionalValidation.isEmpty()) {
            throw new RuntimeException("Validation not found for id: " + aLong);
        }
        Validation validation = optionalValidation.get();
        return modelMapper.map(validation, ValidationDtoRsp.class);
    }

    @Override
    public List<ValidationDtoRsp> findAll() {
        List<Validation> validations = validationRepository.findAll();
        return validations.stream().map(validation -> modelMapper.map(validation, ValidationDtoRsp.class)).toList();
    }
}
