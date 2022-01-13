package com.cesi.ressourcesrelationnelles.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return "Resource not found";
    }
}
