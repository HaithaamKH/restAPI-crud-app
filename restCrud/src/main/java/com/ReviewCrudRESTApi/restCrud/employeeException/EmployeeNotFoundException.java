package com.ReviewCrudRESTApi.restCrud.employeeException;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
