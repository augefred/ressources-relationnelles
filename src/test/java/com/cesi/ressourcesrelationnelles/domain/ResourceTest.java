package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResourceTest {
    @Test
    public void createResource(){
        Resource resource = new Resource();
        assertNotNull(resource);
        resource.setId(1);
        assertEquals(1, resource.getId());
    }

    @Test
    public void getUrl(){
        Resource resource = new Resource();
        assertNotNull(resource);
        resource.setId(1);
        resource.setUrl("C:/Users/image.png");
        assertEquals("C:/Users/image.png", resource.getUrl());
    }

    @Test
    public void getDatePublication(){
        Resource resource = new Resource();
        resource.setId(1);
        resource.setUrl("C:/Users/image.png");
        resource.setDatePublication(new Date(2022, Calendar.JANUARY, 10, 23, 58, 12));
        assertEquals(new Date(2022, Calendar.JANUARY, 10, 23, 58,12), resource.getDatePublication());
    }
}