package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ResourcesController {

    List<Resource> resources = new ArrayList<>();

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return resources;
    }

    @GetMapping("/resources/{id}")
    public Resource getResourceById(@PathVariable("id")Long id) {
        for(int i=0;i<resources.size();i++){
            if(resources.get(i).getId() == id){
                return resources.get(i);
            }
        }
        return new Resource();
    }

    @PostMapping("/resources")
    public String addRessource(Resource resource) {
        for(int i=0;i<resources.size();i++){
            if(resources.get(i) == resource){
                return "La ressource n'a pas pu être ajoutée";
            }
        }
        resources.add(resource);
        return "La resource a bien été ajoutée";
    }

    @PutMapping("/resources/{id}")
    public String updateResource(@PathVariable("id")Long id, Resource resource) {
        for(int i=0;i<resources.size();i++){
            if(resources.get(i).getId() == id){
                resources.remove(i);
                resources.add(resource);
                return "La ressource a été modifiée";
            }
        }
        return "Aucune ressource n'a été modifiée";
    }

    @DeleteMapping("/ressources/{id}")
    public String addRessource(@PathVariable("id")Long id) {
        for(int i=0;i<resources.size();i++){
            if(resources.get(i).getId() == id){
                resources.remove(i);
                return "La ressource a été supprimée";
            }
        }
        return "Aucune ressource n'a été supprimée";
    }
}