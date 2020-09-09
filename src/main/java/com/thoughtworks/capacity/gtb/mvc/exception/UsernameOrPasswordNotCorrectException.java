package com.thoughtworks.capacity.gtb.mvc.exception;

public class UsernameOrPasswordNotCorrectException extends RuntimeException {

    private String message;

    public UsernameOrPasswordNotCorrectException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
