package com.vztot.cinema.validation.constrains;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatchingConstrain {
    String message() default "passwords are not match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String password();
    String repeatedPassword();
}
