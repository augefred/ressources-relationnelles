package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
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

    public List<Resource> list(){
        List<Resource> resources = new ArrayList<>();
        Iterable<Resource> iterable = resourceRepository.findAll();
        for (Resource item : iterable) {
            resources.add(item);
        }
        //List<Ressource> resources = resourceRepository.findAll();
        return resources;
    }

    public List<Resource> list(Date date){
        List<Resource> resources = new ArrayList<>();
        Iterable<Resource> iterable = resourceRepository.findAll();
        for (Resource item : iterable) {
            resources.add(item);
            System.out.println("id= " + item.getId());
            System.out.println("date= " + item.getPublishDate());
        }
        resources = resources.stream().filter(resource -> resource.getPublishDate().compareTo(date) == (0)).collect(Collectors.toList());
        return resources;
    }

    public Resource getById(long id) throws ResourceNotFoundException {
        Optional<Resource> res = resourceRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        throw new ResourceNotFoundException();
    }

    public Resource createResource(Resource resource){
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Resource resource) throws ResourceNotFoundException {
        if(resourceRepository.findById(resource.getId()).isPresent()){
            return resourceRepository.save(resource);
        }
        throw new ResourceNotFoundException();
    }

    public void deleteResource(long id){
        resourceRepository.deleteById(id);
    }
}
