package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<Resource> list(Date date) throws ResourceNotFoundException {
        List<Resource> resources = new ArrayList<>();
        Iterable<Resource> iterable = resourceRepository.findAll();
        for (Resource item : iterable) {
            resources.add(item);
            System.out.println("id= " + item.getId());
            System.out.println("date= " + item.getPublishDate());
        }
        resources = resources.stream().filter(resource -> resource.getPublishDate().compareTo(date) == (0)).collect(Collectors.toList());
        if(resources.size() == 0){
            throw new ResourceNotFoundException();
        }
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

    public List<Resource> listOrderByDateDesc() {
        List<Resource> res = this.list();
        res.sort(Comparator.comparing(Resource::getPublishDate));
        return res;
    }

    public List<Resource> search(String reseachText) throws ResourceNotFoundException {
        List<Resource> res = this.list();
        res = res.stream().filter(resource -> resource.getTitle().contains(reseachText)).collect(Collectors.toList());
        if(res.size() == 0){
            throw new ResourceNotFoundException();
        }
        return res;
    }
}
