package com.nurlan.department.service.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String message){
        super(message);
    }
}
