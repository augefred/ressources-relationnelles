package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.service.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ResourcesController {

    private final ResourceService resourceService;

    public ResourcesController(ResourceService resourceService){
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<Resource> getResourcesbyDate(@RequestParam(required = false) Date date) {
        if(date == null) {
            return resourceService.list();
        }
        return resourceService.list(date);
    }

    @GetMapping("/resources/{id}")
    public Resource getResourceById(@PathVariable("id")Long id) {
        try{
            return resourceService.getById(id);
        }
        catch (ResourceNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/resources")
    @ResponseBody
    public Resource addRessource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @PutMapping("/resources")
    @ResponseBody
    public Resource updateResource(@PathVariable("id") Long id, @RequestBody Resource resource) throws ResourceNotFoundException {
        resource.setRES_ID(id);
        return resourceService.updateResource(resource);
    }

    @DeleteMapping("/resources/{id}")
    public String deleteResource(@PathVariable("id")Long id) {
        resourceService.deleteResource(id);
        return "Ressource supprimée";
    }
}