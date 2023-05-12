package ua.edu.lnu.schedulebuilder.exception;

import java.io.InvalidObjectException;

import lombok.Getter;
import lombok.Setter;
import ua.edu.lnu.schedulebuilder.dto.RegistrationRequestDTO;

@Getter
@Setter
public class InvalidEmailException extends InvalidObjectException {
    private static final String INVALID_EMAIL = "email not valid";
    private RegistrationRequestDTO request;

    public InvalidEmailException(String message,
        RegistrationRequestDTO request) {
        super(message.isEmpty() ? INVALID_EMAIL : message);
        this.request = request;
    }

    public InvalidEmailException() {
        super(INVALID_EMAIL);
    }
}
