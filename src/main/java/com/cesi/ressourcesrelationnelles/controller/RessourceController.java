package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Ressource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.service.RessourceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class RessourceController {

    private final RessourceService ressourceService;

    public RessourceController(RessourceService resourceService){
        this.ressourceService = resourceService;
    }

    @GetMapping("/ressource")
    public List<Ressource> getResourcesbyDate(@RequestParam(required = false) Date date) {
        if(date == null) {
            return ressourceService.list();
        }
        return ressourceService.list(date);
    }

    @GetMapping("/ressource/{id}")
    public Ressource getResourceById(@PathVariable("id")Long id) {
        try{
            return ressourceService.getById(id);
        }
        catch (ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/ressource")
    @ResponseBody
    public Ressource addRessource(@RequestBody Ressource ressource) {
        return ressourceService.createResource(ressource);
    }

    @PutMapping("/ressource")
    @ResponseBody
    public Ressource updateResource(@PathVariable("id") Long id, @RequestBody Ressource ressource) throws ResourceNotFoundException {
        ressource.setRES_ID(id);
        return ressourceService.updateResource(ressource);
    }

    @DeleteMapping("/ressource/{id}")
    public String deleteResource(@PathVariable("id")Long id) {
        ressourceService.deleteResource(id);
        return "Ressource supprimée";
    }
}