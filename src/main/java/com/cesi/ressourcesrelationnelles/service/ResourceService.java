package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> list(){
        return resourceRepository.findAll();
    }

    public List<Resource> list(Date date){
        List<Resource> resources = resourceRepository.findAll();
        resources = resources.stream().filter(resource -> resource.getDatePublication().compareTo(date) == (0)).collect(Collectors.toList());
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
