package ua.edu.lnu.schedulebuilder.exception;

import lombok.Getter;
import lombok.Setter;
import ua.edu.lnu.schedulebuilder.dto.UserDTO;

@Getter
@Setter
public class EmailAlreadyTakenException extends IllegalStateException {
    private static final String EMAIL_ALREADY_TAKEN = "email already taken";
    private UserDTO userDTO;

    public EmailAlreadyTakenException(String message, UserDTO userDTO) {
        super(message.isEmpty() ? EMAIL_ALREADY_TAKEN : message);
        this.userDTO = userDTO;
    }

    public EmailAlreadyTakenException() {
        super(EMAIL_ALREADY_TAKEN);
    }

}
