package com.fbs.central_api.exceptions;

public class NoSystemAdminsFoundException extends RuntimeException{
    public NoSystemAdminsFoundException(String message){
        super(message);
    }
}
