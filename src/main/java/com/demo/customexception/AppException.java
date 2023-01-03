package com.demo.customexception;

import io.micronaut.http.HttpStatus;

import java.util.Objects;

public class AppException extends Exception {
    HttpStatus status;
    public AppException(String msg, HttpStatus httpStatus){
        super(msg);
        this.status = httpStatus;
    }
    public AppException(String msg){
        super(msg);
    }
}
