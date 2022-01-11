package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RessourcesController {

    HashMap<Long, String> ressources = new HashMap<>();

    @GetMapping("/ressources")
    public HashMap<Long, String> getAllRessources() {
        return ressources;
    }

    @GetMapping("/ressources/{id}")
    public String getRessourceById(Long id) {
        if(ressources.containsKey(id)){
            return ressources.get(id);
        }
        return "Aucune ressource n'a été trouvée";
    }

    @PostMapping("/ressources")
    public String addRessource(String ressource) {
        try{
            ressources.putIfAbsent((long) ressources.size(), ressource);
            return "La ressource a été ajoutée";
        }
        catch (Exception ex){
            return "Le commentaire n'a pu être ajouté";
        }
    }
}