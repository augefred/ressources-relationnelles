package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResourceTest {
    @Test
    public void createResource(){
        Ressource resource = new Ressource();
        assertNotNull(resource);
        resource.setRES_ID(1);
        assertEquals(1, resource.getRES_ID());
    }

    @Test
    public void getUrl(){
        Ressource resource = new Ressource();
        assertNotNull(resource);
        resource.setRES_ID(1);
        resource.setRES_URL("C:/Users/image.png");
        assertEquals("C:/Users/image.png", resource.getRES_URL());
    }

    @Test
    public void getDatePublication(){
        Ressource resource = new Ressource();
        resource.setRES_ID(1);
        resource.setRES_URL("C:/Users/image.png");
        resource.setRES_DatePublication(new Date(2022, Calendar.JANUARY, 10, 23, 58, 12));
        assertEquals(new Date(2022, Calendar.JANUARY, 10, 23, 58,12), resource.getRES_DatePublication());
    }
}