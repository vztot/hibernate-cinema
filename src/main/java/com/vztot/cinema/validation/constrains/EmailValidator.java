package com.vztot.cinema.validation.constrains;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    private static final String EMAIL_MATCHING_REGEX = ".+@.+\\..+";

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {
        return email != null && email.matches(EMAIL_MATCHING_REGEX);
    }
}
