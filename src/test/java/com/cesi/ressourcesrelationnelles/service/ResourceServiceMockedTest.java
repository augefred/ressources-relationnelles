package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Ressource;
import com.cesi.ressourcesrelationnelles.repository.RessourceRepository;
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
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ResourceServiceMockedTest {

    @InjectMocks
    public RessourceService resourceService;

    @Mock
    public RessourceRepository resourceRepository;

    @BeforeTestClass
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findResoucesByDateTest() throws ParseException {
        // Given
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Ressource> mockResources = new ArrayList<>();
        mockResources.add(new Ressource("titre", formatter.parse("2022-01-14 18:54:21"), "C:/"));
        mockResources.add(new Ressource("titre2", formatter.parse("2022-01-13 08:15:40"), "D:/"));
        Mockito.when(resourceRepository.findAll()).thenReturn(mockResources);

        // when
        String dateInString = "2022-01-13 08:15:40";
        Date date = formatter.parse(dateInString);
        List<Ressource> resources = resourceService.list(date);
        assertNotNull(resources);
        //Then
        assertEquals(1, resources.size());
        assertEquals(date, resources.get(0).getRES_DatePublication());
    }
}
