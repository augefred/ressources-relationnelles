package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Ressource;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceServiceTest {
    @Autowired
    private RessourceService resourceService;

    @Test
    void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
        List<Ressource> resources = resourceService.list();
        assertEquals(3, resources.size());
    }

    @Test
    void getById() throws ResourceNotFoundException {
        Ressource resource = resourceService.getById(1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        assertEquals(1, resource.getRES_ID());
        assertEquals("titre", resource.getRES_Title());
        String date = dateFormat.format(resource.getRES_DatePublication());
        assertEquals("2022-01-12 12:55:10", date);
        assertEquals("C:/Users", resource.getRES_URL());
    }

    @Test
    void getByIdException(){
        assertThrows(ResourceNotFoundException.class, ()-> resourceService.getById(-1));
    }

    @Test
    void updateException() {
        Ressource res = new Ressource();
        res.setRES_ID(-1);
        assertThrows(ResourceNotFoundException.class, ()-> resourceService.updateResource(res));
    }

    @Test
    void getResourcesByDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2022-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        List<Ressource> resources = resourceService.list(date);
        assertEquals(1, resources.size());
        assertEquals(date, resources.get(0).getRES_DatePublication());
    }
}
