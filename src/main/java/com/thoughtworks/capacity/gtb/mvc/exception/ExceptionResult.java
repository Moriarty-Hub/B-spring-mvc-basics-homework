package com.thoughtworks.capacity.gtb.mvc.exception;

public class ExceptionResult {

    private Integer errorCode;
    private String message;

    public ExceptionResult(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
