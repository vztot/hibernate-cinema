package com.vztot.cinema.model.dto.request;

import com.vztot.cinema.validation.constrains.EmailConstraint;
import com.vztot.cinema.validation.constrains.PasswordMatchingConstrain;
import javax.validation.constraints.NotNull;
import lombok.Data;

@PasswordMatchingConstrain(password = "password", repeatedPassword = "repeatPassword")
@Data
public class UserRegistrationRequestDto {
    @EmailConstraint
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;
}
