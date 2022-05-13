package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Resource;
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
    public List<Resource> getResourcesbyDate(@RequestParam(required = false) Date date) throws ResourceNotFoundException {
        if(date == null) {
            return ressourceService.list();
        }
        return ressourceService.list(date);
    }

    @GetMapping("/ressource/{id}")
    public Resource getResourceById(@PathVariable("id")Long id) {
        try{
            return ressourceService.getById(id);
        }
        catch (ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/ressource")
    @ResponseBody
    public Resource addRessource(@RequestBody com.cesi.ressourcesrelationnelles.dto.Resource ressource) {

        return ressourceService.createResource(ressource.getModel());
    }

    @PutMapping("/ressource/{id}")
    @ResponseBody
    public Resource updateResource(@PathVariable("id") Long id, @RequestBody com.cesi.ressourcesrelationnelles.dto.Resource ressource) throws ResourceNotFoundException {
        ressource.setId(id);
        return ressourceService.updateResource(ressource.getModel());
    }

    @DeleteMapping("/ressource/{id}")
    public String deleteResource(@PathVariable("id")Long id) {
        ressourceService.deleteResource(id);
        return "Ressource supprimée";
    }
}