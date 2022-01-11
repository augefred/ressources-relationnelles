package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RessourcesController {

    @GetMapping("/ressources")
    public String index() {
        return "Index des ressources";
    }
}