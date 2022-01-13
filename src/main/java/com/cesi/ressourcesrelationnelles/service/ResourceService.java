package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> list(){
        return resourceRepository.findAll();
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
