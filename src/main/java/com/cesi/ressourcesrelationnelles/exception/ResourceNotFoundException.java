package com.cesi.ressourcesrelationnelles.exception;

public class ResourceNotFoundException extends Exception {

    @Override
    public String getMessage(){
        return "Resource not found";
    }
}
