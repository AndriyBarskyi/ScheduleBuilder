package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.lnu.schedulebuilder.validator.EmailConstraint;
import ua.edu.lnu.schedulebuilder.validator.NameConstraint;
import ua.edu.lnu.schedulebuilder.validator.PasswordConstraint;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDTO {
    @NotNull
    @NameConstraint
    private String firstName;

    @NotNull
    @NameConstraint
    private String lastName;

    @NotNull
    @EmailConstraint
    private String email;

    @NotNull
    @PasswordConstraint
    private String password;
}