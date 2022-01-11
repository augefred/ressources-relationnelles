package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {
    @GetMapping("/statistics")
    public String index() {
        return "Voici les statistiques";
    }
}
