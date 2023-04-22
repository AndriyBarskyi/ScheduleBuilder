package ua.edu.lnu.schedulebuilder.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.exception.InvalidEntityException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(EntityNotExistsException.class)
    protected ResponseEntity<Object> handleEntityNotExists(
        EntityNotExistsException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(InvalidEntityException.class)
    protected ResponseEntity<Object> handleInvalidEntity(
        InvalidEntityException ex) {
        ApiError apiError = new ApiError(BAD_REQUEST);

        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}
