package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ResourceTest {
    @Test
    public void createResource(){
        Resource resource = new Resource();
        assertNotNull(resource);
        resource.setId(1L);
        assertEquals(1, resource.getId());
    }

    @Test
    public void getUrl(){
        Resource resource = new Resource();
        assertNotNull(resource);
        resource.setId(1L);
        resource.setUrlContent("C:/Users/image.png");
        assertEquals("C:/Users/image.png", resource.getUrlContent());
    }

    @Test
    public void getDatePublication(){
        Resource resource = new Resource();
        resource.setId(1L);
        resource.setUrlContent("C:/Users/image.png");
        resource.setPublishDate(new Date(2022, Calendar.JANUARY, 10, 23, 58, 12));
        assertEquals(new Date(2022, Calendar.JANUARY, 10, 23, 58,12), resource.getPublishDate());
    }
}