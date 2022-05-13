package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
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
        List<Resource> resources = resourceService.list();
        assertEquals(4, resources.size());
    }

    @Test
    void getById() throws ResourceNotFoundException {
        Resource resource = resourceService.getById(1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        assertEquals(1, resource.getId());
        assertEquals("test0", resource.getTitle());
        String date = dateFormat.format(resource.getPublishDate());
        assertEquals("2022-01-13 08:15:40", date);
        assertEquals("test", resource.getUrlContent());
    }

    @Test
    void getOrderByDate(){
        List<Resource> res = resourceService.listOrderByDateDesc();
        assertEquals(3, res.get(0).getId());
        assertEquals(4, res.get(1).getId());
        assertEquals(1, res.get(2).getId());
        assertEquals(2, res.get(3).getId());
    }

    @Test
    void getResourcesByDate() throws ParseException, ResourceNotFoundException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2022-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        List<Resource> resources = resourceService.list(date);
        assertEquals(1, resources.size());
        assertEquals(date, resources.get(0).getPublishDate());
    }

    @Test
    void getSearchResult() throws ResourceNotFoundException {
        List<Resource> res = resourceService.search("test");
        assertEquals(2, res.size());
    }

    @Test
    void getSearchResultException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            List<Resource> res = resourceService.search("aaaaaaaaaaaaaaa");
        });
    }

    @Test
    void getByIdException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            Resource res = resourceService.getById(24);
        });
    }

    @Test
    void getByDateException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateInString = "2012-01-12 12:55:10";
            Date date = formatter.parse(dateInString);
            List<Resource> res = resourceService.list(date);
        });
    }
}
