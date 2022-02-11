package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Ressource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RessourceService {

    @Autowired
    private final RessourceRepository resourceRepository;

    public RessourceService(RessourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    public List<Ressource> list(){
        /*List<Ressource> resources = new ArrayList<>();
        Iterable<Ressource> iterable = resourceRepository.findAll();
        for (Ressource item : iterable) {
            resources.add(item);
        }*/
        List<Ressource> resources = resourceRepository.findAll();
        return resources;
    }

    public List<Ressource> list(Date date){
        /*List<Ressource> resources = new ArrayList<>();
        Iterable<Ressource> iterable = resourceRepository.findAll();
        for (Ressource item : iterable) {
            resources.add(item);
        }*/
        List<Ressource> resources = resourceRepository.findAll();
        resources = resources.stream().filter(resource -> resource.getRES_DatePublication().compareTo(date) == (0)).collect(Collectors.toList());
        return resources;
    }

    public Ressource getById(long id) throws ResourceNotFoundException {
        Optional<Ressource> res = resourceRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        throw new ResourceNotFoundException();
    }

    public Ressource createResource(Ressource resource){
        return resourceRepository.save(resource);
    }

    public Ressource updateResource(Ressource resource) throws ResourceNotFoundException {
        if(resourceRepository.findById(resource.getRES_ID()).isPresent()){
            return resourceRepository.save(resource);
        }
        throw new ResourceNotFoundException();
    }

    public void deleteResource(long id){
        resourceRepository.deleteById(id);
    }
}
