package com.example.Challenges2.exception;

public class ExceptionNotFound extends RuntimeException{
    public ExceptionNotFound(String format){
        super(format);
    }
}
