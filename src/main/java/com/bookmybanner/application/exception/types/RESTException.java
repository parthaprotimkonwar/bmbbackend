package com.bookmybanner.application.exception.types;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
public class RESTException extends Exception{

    private String errorCode;
    private String errorMessage;

    public RESTException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
