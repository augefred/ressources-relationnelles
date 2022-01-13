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
        Optional<Resource> resource = resourceService.getById(id);
        if(resourceService.getById(id).isPresent()){
            return resource.get();
        }
        return new Resource();
    }

    @PostMapping("/resources")
    @ResponseBody
    public Resource addRessource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @PutMapping("/resources")
    @ResponseBody
    public Resource updateResource(@PathVariable("id") Long id, @RequestBody Resource resource) {
        resource.setId(id);
        return resourceService.updateResource(resource);
    }

    @DeleteMapping("/resources/{id}")
    public String deleteResource(@PathVariable("id")Long id) {
        resourceService.deleteResource(id);
        return "Ressource supprimée";
    }
}