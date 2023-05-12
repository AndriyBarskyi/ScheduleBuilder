package ua.edu.lnu.schedulebuilder.exception;

import lombok.Getter;
import lombok.Setter;
import ua.edu.lnu.schedulebuilder.dto.RegistrationRequestDTO;

@Getter
@Setter
public class InvalidPasswordException extends Exception {
    private static final String INVALID_PASSWORD = "password not valid";
    private RegistrationRequestDTO requestDTO;

    public InvalidPasswordException(String message,
        RegistrationRequestDTO requestDTO) {
        super(message.isEmpty() ? INVALID_PASSWORD : message);
        this.requestDTO = requestDTO;
    }

    public InvalidPasswordException() {
        super(INVALID_PASSWORD);
    }
}
