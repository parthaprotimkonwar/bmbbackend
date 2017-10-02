package com.bookmybanner.application.exception;

import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.application.exception.types.RESTException;
import com.bookmybanner.application.exception.types.ResourceAlreadyExistsException;
import com.bookmybanner.application.exception.types.ResourceNotExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
@ControllerAdvice
@ResponseBody
public class ApplicationExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ApplicationExceptionHandler.class.getName());

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RESTException.class)
    public ErrorResponse handleApplicationException(RESTException restException) {
        logger.info("Handling applicationException. Data : {}", restException);
        return new ErrorResponse(restException.getErrorCode(), restException.getErrorMessage());
    }

    @ExceptionHandler(value = DatabaseException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseException(DatabaseException databaseException) {
        ErrorResponse errorResponse = new ErrorResponse(databaseException.getErrorCode(), databaseException.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ResourceNotExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotExistException(ResourceNotExistsException resourceNotExistException) {
        ErrorResponse errorResponse = new ErrorResponse(resourceNotExistException.getErrorCode(), resourceNotExistException.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistException(ResourceAlreadyExistsException resourceAlreadyExistException) {
        ErrorResponse errorResponse = new ErrorResponse(resourceAlreadyExistException.getErrorCode(), resourceAlreadyExistException.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    /*@ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handle(MethodArgumentNotValidException exception) {
        return error(exception.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList()));
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handle(ConstraintViolationException exception) {
        return error(exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList()));
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handle(MethodArgumentTypeMismatchException exception) {
        return error(exception.getMessage());
    }

    private Map error(Object message) {
        return Collections.singletonMap("error", message);
    }*/
}
