package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceServiceTest {
    @Autowired
    private ResourceService resourceService;

    @Test
    void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
        List<Resource> resources = resourceService.list();
        assertEquals(3, resources.size());
    }

    @Test
    void getById() throws ResourceNotFoundException {
        Resource resource = resourceService.getById(1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        assertEquals(1, resource.getId());
        assertEquals("titre", resource.getTitle());
        String date = dateFormat.format(resource.getDatePublication());
        assertEquals("2022-01-12 12:55:10", date);
        assertEquals("C:/Users", resource.getUrl());
    }

    @Test
    void getByIdException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            resourceService.getById(-1);
        });
    }
    @Test
    void updateException() throws ResourceNotFoundException {
            Resource res = new Resource();
            res.setId(-1);
            assertThrows(ResourceNotFoundException.class, ()->{
                resourceService.updateResource(res);
            });

    }
}
