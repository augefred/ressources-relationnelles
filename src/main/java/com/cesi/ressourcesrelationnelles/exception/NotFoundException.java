package com.cesi.ressourcesrelationnelles.exception;

public class NotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "Comment not found";
    }

    public NotFoundException(String message) {
        super(message);
    }
}
