package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.repository.ResourceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ResourceServiceMockedTest {

    @InjectMocks
    public ResourceService resourceService;

    @Mock
    public ResourceRepository resourceRepository;

    @BeforeTestClass
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findResoucesByDateTest() throws ParseException {
        // Given
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Resource> mockResources = new ArrayList<>();
        mockResources.add(new Resource("titre", formatter.parse("2022-01-14 18:54:21"), "C:/"));
        mockResources.add(new Resource("titre2", formatter.parse("2022-01-13 08:15:40"), "D:/"));
        Mockito.when(resourceRepository.findAll()).thenReturn(mockResources);

        // when
        String dateInString = "2022-01-13 08:15:40";
        Date date = formatter.parse(dateInString);
        List<Resource> resources = resourceService.list(date);
        assertNotNull(resources);
        //Then
        assertEquals(1, resources.size());
        assertEquals(date, resources.get(0).getDatePublication());
    }
}
