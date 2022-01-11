package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("/users")
    public String index() {
        return "Hello users !";
    }

}