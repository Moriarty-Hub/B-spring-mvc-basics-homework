package com.thoughtworks.capacity.gtb.mvc.handler;

import com.thoughtworks.capacity.gtb.mvc.exception.ExceptionResult;
import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameOrPasswordNotCorrectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;

@ControllerAdvice
public class UserExceptionHandler {

    private static final String ERROR_INFO_FORMAT_FOR_MISSED_PARAMETER = "The parameter %s cannot be null";

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResult> userAlreadyExistExceptionHandler(UserAlreadyExistException exception) {
        ExceptionResult exceptionResult = new ExceptionResult(exception.getMessage());
        return ResponseEntity.badRequest().body(exceptionResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResult> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        ExceptionResult exceptionResult = new ExceptionResult(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
        return ResponseEntity.badRequest().body(exceptionResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResult> constraintViolationExceptionHandler(ConstraintViolationException exception) {
        String message = "";
        for (ConstraintViolation<?> constraint : exception.getConstraintViolations()) {
            message = constraint.getMessage();
            break;
        }
        ExceptionResult errorResult = new ExceptionResult(message);
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(UsernameOrPasswordNotCorrectException.class)
    public ResponseEntity<ExceptionResult> usernameOrPasswordNotCorrectExceptionHandler(UsernameOrPasswordNotCorrectException exception) {
        ExceptionResult exceptionResult = new ExceptionResult(exception.getMessage());
        return ResponseEntity.badRequest().body(exceptionResult);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResult> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException exception) {
        ExceptionResult exceptionResult = new ExceptionResult(String.format(ERROR_INFO_FORMAT_FOR_MISSED_PARAMETER, exception.getParameterName()));
        return ResponseEntity.badRequest().body(exceptionResult);
    }
}
