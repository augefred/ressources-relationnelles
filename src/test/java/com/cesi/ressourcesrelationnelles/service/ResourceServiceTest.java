package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ResourceServiceTest {
    @Autowired
    private ResourceService resourceService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
        List<Resource> resources = resourceService.list();
        assertEquals(3, resources.size());
    }

    @Test
    public void getById(){
        Optional<Resource> res = resourceService.getById(1);
        assertEquals(true, res.isPresent());
        Resource resource = res.get();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        assertEquals(1, resource.getId());
        assertEquals("titre", resource.getTitle());
        String date = dateFormat.format(resource.getDatePublication());
        assertEquals("2022-01-12 12:55:10", date);
        assertEquals("C:/Users", resource.getUrl());
    }
}
