package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ResourcesController {

    HashMap<Long, String> ressources = new HashMap<>();

    @GetMapping("/ressources")
    public HashMap<Long, String> getAllRessources() {
        return ressources;
    }

    @GetMapping("/ressources/{id}")
    public String getRessourceById(@PathVariable("id")Long id) {
        System.out.println(id);
        if(ressources.containsKey(id)){
            return ressources.get(id);
        }
        return "Aucune ressource n'a ete trouvee";
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

    @PutMapping("/ressources")
    public String updateRessource(Long id, String ressource) {
        ressources.put(id, ressource);
        return "La ressource a été modifiée";
    }

    @DeleteMapping("/ressources/{id}")
    public String addRessource(@PathVariable("id")Long id) {
        ressources.remove(id);
        return "La ressource a été supprimé";
    }
}