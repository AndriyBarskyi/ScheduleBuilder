package ua.edu.lnu.schedulebuilder.exception;

import lombok.Getter;
import lombok.Setter;
import ua.edu.lnu.schedulebuilder.model.User;

@Getter
@Setter
public class EmailNotConfirmedException extends IllegalStateException {
    private static final String EMAIL_NOT_CONFIRMED = "email %s not confirmed";
    private User user;

    public EmailNotConfirmedException(String message, User user) {
        super(message.isEmpty() ? EMAIL_NOT_CONFIRMED : message);
        this.user = user;
    }

    public EmailNotConfirmedException() {
        super(EMAIL_NOT_CONFIRMED);
    }
}
