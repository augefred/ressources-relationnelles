package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
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

    public Resource getById(long id){
        return resourceRepository.findAllById(Collections.singleton(id)).get(0);
    }

    public Resource createResource(Resource resource){
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Resource resource){
        return resourceRepository.save(resource);
    }

    public void deleteResource(long id){
        resourceRepository.deleteById(id);
    }
}
