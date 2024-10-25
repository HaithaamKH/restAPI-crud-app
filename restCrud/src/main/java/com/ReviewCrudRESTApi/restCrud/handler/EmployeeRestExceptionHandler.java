package com.ReviewCrudRESTApi.restCrud.handler;

import com.ReviewCrudRESTApi.restCrud.employeeException.EmployeeErrorResponse;
import com.ReviewCrudRESTApi.restCrud.employeeException.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> employeeNotFound(EmployeeNotFoundException exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> badRequest(Exception exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }

}
