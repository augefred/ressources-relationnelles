package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Category;
import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.domain.Type;
import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.exception.ResourceAlreadyExistException;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.cesi.ressourcesrelationnelles.exception.ResourceNotValidException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ResourceServiceTest {
    @Autowired
    private RessourceService resourceService;

    @Test
    @Order(1)
    void whenApplicationStarts_thenHibernateCreatesInitialRecords(){
        List<Resource> resources = resourceService.list();
        assertEquals(4, resources.size());
    }

    @Test
    @Order(2)
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
    @Order(3)
    void getOrderByDate(){
        List<Resource> res = resourceService.listOrderByDateDesc();
        assertEquals(3, res.get(0).getId());
        assertEquals(4, res.get(1).getId());
        assertEquals(1, res.get(2).getId());
        assertEquals(2, res.get(3).getId());
    }

    @Test
    @Order(4)
    void getResourcesByDate() throws ParseException, ResourceNotFoundException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2022-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        List<Resource> resources = resourceService.list(date);
        assertEquals(1, resources.size());
        assertEquals(date, resources.get(0).getPublishDate());
    }

    @Test
    @Order(5)
    void getSearchResult() throws ResourceNotFoundException {
        List<Resource> res = resourceService.search("test");
        assertEquals(2, res.size());
    }

    @Test
    @Order(6)
    void getSearchResultException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            List<Resource> res = resourceService.search("aaaaaaaaaaaaaaa");
        });
    }

    @Test
    @Order(7)
    void getByIdException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            Resource res = resourceService.getById(24);
        });
    }

    @Test
    @Order(8)
    void getByDateException(){
        assertThrows(ResourceNotFoundException.class, ()->{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateInString = "2012-01-12 12:55:10";
            Date date = formatter.parse(dateInString);
            List<Resource> res = resourceService.list(date);
        });
    }

    @Test
    @Order(9)
    void createResource() throws ResourceNotValidException, ParseException, ResourceNotFoundException, ResourceAlreadyExistException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        Resource res = new Resource(5L, "createJunit", date, date, true, "c:", true, 300L, false, user, type, category);
        Resource temp = resourceService.createResource(res);
        Resource result = resourceService.getById(temp.getId());
        assertEquals(5, result.getId());
        assertEquals("test", result.getAuthor().getFirstName());
    }

    @Test
    @Order(10)
    //ID null
    void createResourceInvalidException() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(null, "createJunit", date, date, true, "c:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(11)
    //ID deja existant
    void createResourceInvalidException2() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceAlreadyExistException.class, () -> {
            Resource res = new Resource(1L, "createJunit", date, date, true, "c:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(12)
    //title null
    void createResourceInvalidException3() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, null, date, date, true, "c:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(13)
    //publishDate null
    void createResourceInvalidException4() {
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", null, null, true, "c:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(14)
    //urlContent null
    void createResourceInvalidException5() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, null, true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(15)
    //viewNumber null
    void createResourceInvalidException6() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, null, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(16)
    //author null
    void createResourceInvalidException7() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, 300L, false, null, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(17)
    //type null
    void createResourceInvalidException8() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, 300L, false, user, null, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(18)
    //category null
    void createResourceInvalidException9() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, 300L, false, user, type, null);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(19)
    //author invalid
    void createResourceInvalidException10() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(8L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(20)
    //type invalid
    void createResourceInvalidException11() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(8L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(21)
    //category invalid
    void createResourceInvalidException12() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(8L);
        Type type = new Type();
        type.setId(1L);
        assertThrows(ResourceNotValidException.class, () -> {
            Resource res = new Resource(6L, "titre", date, null, true, "C:", true, 300L, false, user, type, category);
            resourceService.createResource(res);
        });
    }

    @Test
    @Order(22)
    void deleteResource() throws ResourceNotFoundException {
        Resource res = resourceService.getById(1L);
        resourceService.deleteResource(1L);
        assertThrows(ResourceNotFoundException.class, () -> {
            resourceService.getById(1L);
        });
    }

    @Test
    @Order(23)
    void deleteResourceException()  {
        assertThrows(ResourceNotFoundException.class, () -> {
            resourceService.deleteResource(10L);
        });
    }

    @Test
    @Order(24)
    void updateResource() throws ParseException, ResourceNotFoundException, ResourceNotValidException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2022-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        Resource old = resourceService.getById(4L);
        System.out.println("date : "+old.getPublishDate());
        System.out.println(old.getPublishDate().compareTo(date));
        Resource res = new Resource(4L, "updateJunit", date, date, true, "c:", true, 300L, false, user, type, category);
        resourceService.updateResource(res);
        assertNotEquals(old, resourceService.getById(4L));
    }

    @Test
    @Order(25)
    void updateResourceException() throws ParseException, ResourceNotFoundException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2018-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        Resource res = new Resource(18L, "updateJunit", date, date, true, "c:", true, 300L, false, user, type, category);
        assertThrows(ResourceNotFoundException.class, () -> {
            resourceService.updateResource(res);
        });
    }

    @Test
    @Order(26)
    //publishDate modifiée
    void updateResourceException2() throws ParseException, ResourceNotFoundException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = "2019-01-12 12:55:10";
        Date date = formatter.parse(dateInString);
        User user = new User();
        user.setId(1L);
        Category category = new Category();
        category.setId(1L);
        Type type = new Type();
        type.setId(1L);
        Resource res = new Resource(4L, "updateJunit", date, date, true, "c:", true, 300L, false, user, type, category);
        assertThrows(ResourceNotValidException.class, () -> {
            resourceService.updateResource(res);
        });
    }
}
