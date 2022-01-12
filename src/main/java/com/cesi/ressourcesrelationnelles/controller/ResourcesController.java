package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ResourcesController {

    private ResourceService resourceService;

    public ResourcesController(ResourceService resourceService){
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return resourceService.list();
    }

    @GetMapping("/resources/{id}")
    public Resource getResourceById(@PathVariable("id")Long id) {
        return resourceService.getById(id);
    }

    @PostMapping("/resources")
    @ResponseBody
    public Resource addRessource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @PutMapping("/resources")
    @ResponseBody
    public Resource updateResource(@RequestBody Resource resource) {
        return resourceService.updateResource(resource);
    }

    @DeleteMapping("/resources/{id}")
    public String deleteResource(@PathVariable("id")Long id) {
        resourceService.deleteResource(id);
        return "Ressource supprimée";
    }
}