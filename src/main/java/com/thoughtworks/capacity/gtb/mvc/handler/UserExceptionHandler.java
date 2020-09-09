package com.thoughtworks.capacity.gtb.mvc.handler;

import com.thoughtworks.capacity.gtb.mvc.exception.ExceptionResult;
import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class UserExceptionHandler {

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
}
