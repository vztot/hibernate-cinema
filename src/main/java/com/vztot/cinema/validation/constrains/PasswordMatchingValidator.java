package com.vztot.cinema.validation.constrains;

import com.vztot.cinema.model.dto.request.UserRegistrationRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchingValidator
        implements ConstraintValidator<PasswordMatchingConstrain, UserRegistrationRequestDto> {

    @Override
    public boolean isValid(UserRegistrationRequestDto dto, ConstraintValidatorContext ctx) {
        return dto.getPassword().equals(dto.getRepeatPassword());
    }
}
