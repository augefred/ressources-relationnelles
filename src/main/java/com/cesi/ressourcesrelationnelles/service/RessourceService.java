package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.exception.ResourceAlreadyExistException;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotValidException;
import com.cesi.ressourcesrelationnelles.repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
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

    public Resource createResource(Resource resource) throws ResourceNotValidException, ResourceAlreadyExistException, ResourceNotFoundException {
        if(resource.getId() == null || resource.getTitle() == null || resource.getPublishDate() == null || resource.getUrlContent() == null || resource.getViewNumber() == null || resource.getAuthor() == null || resource.getType() == null || resource.getCategory() == null){
            throw new ResourceNotValidException();
        }
        if(this.idExists(resource.getId())){
            throw new ResourceAlreadyExistException();
        }
        try {
            return resourceRepository.save(resource);
        }catch(JpaObjectRetrievalFailureException e){
            throw new ResourceNotValidException();
        }
    }

    private boolean idExists(Long id) {
        Optional<Resource> res = resourceRepository.findById(id);
        if(res.isPresent()){
            return true;
        }
        return false;
    }

    public Resource updateResource(Resource resource) throws ResourceNotFoundException, ResourceNotValidException {
        Optional<Resource> resOpt = resourceRepository.findById(resource.getId());
        if(resOpt.isPresent()){
            Resource old = resOpt.get();
            if(old.getPublishDate().compareTo(resource.getPublishDate()) != 0){
                throw new ResourceNotValidException();
            }
            return resourceRepository.save(resource);
        }
        throw new ResourceNotFoundException();
    }

    public void deleteResource(long id) throws ResourceNotFoundException {
        if(this.idExists(id)) {
            resourceRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException();
        }
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
