package com.vztot.cinema.validation.constrains;

import com.vztot.cinema.model.dto.request.UserRegistrationRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchingValidator
        implements ConstraintValidator<PasswordMatchingConstrain, UserRegistrationRequestDto> {
    private String password;
    private String repeatedPassword;

    @Override
    public void initialize(PasswordMatchingConstrain constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.repeatedPassword = constraintAnnotation.repeatedPassword();
    }

    @Override
    public boolean isValid(UserRegistrationRequestDto dto, ConstraintValidatorContext ctx) {
        String passwordValue
                = (String) new BeanWrapperImpl(dto).getPropertyValue(password);
        String repeatedPasswordValue
                = (String) new BeanWrapperImpl(dto).getPropertyValue(repeatedPassword);
        return passwordValue.equals(repeatedPasswordValue);
    }
}
