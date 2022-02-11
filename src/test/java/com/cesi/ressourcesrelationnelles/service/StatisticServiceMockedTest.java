package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StatisticServiceMockedTest {
    /*@InjectMocks
    private StatisticService statService;

    @Mock
    private StatisticRepository statRepository;

    @BeforeTestClass
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findStatisticByIdTest() throws NotFoundException {
        List<Statistic> mockStats = new ArrayList<>();
        mockStats.add(new Statistic(1, 1, 200));
        mockStats.add(new Statistic(2, 3, 250));

        Mockito.when(statRepository.findById(2l)).thenReturn(Optional.of(new Statistic(2, 3, 250)));

        Statistic actualStat = statService.getStatistic(2);
        assertNotNull(actualStat);
    }

    @Test
    public void findStatisticByNbVuesNoResultTest() {
        List<Statistic> mockStats = new ArrayList<>();

        mockStats.add(new Statistic(1, 1, 200));
        mockStats.add(new Statistic(2, 1, 250));
        mockStats.add(new Statistic(3, 1, 300));

        Mockito.when(statRepository.findAll()).thenReturn(mockStats);

        List<Statistic> stats = statService.list(300);
        assertNotNull(stats);

        Mockito.verify(statRepository, Mockito.times(1)).findAll();
        assertEquals(1, stats.size());
        assertEquals(300, stats.get(0).getNbVues());
    }*/
}
