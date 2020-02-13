package com.example.myorder.api.exceptions;

public class AlreadyExistsException extends Exception {

    public AlreadyExistsException(String message){
        super(message);
    }
}
