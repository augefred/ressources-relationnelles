package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatisticServiceTest {
    @Autowired
    private StatisticService statService;

    @Test
    public void statisticListTest() {
        List<Statistic> stats = statService.list();

        assertFalse(stats.isEmpty());
    }

    @Test
    public void createStatisticTest() {
        statService.create(new Statistic());
        List<Statistic> stats = statService.list();
        assertEquals(1, stats.size());
    }

    @Test
    public void deleteStatisticTest() {
        statService.delete(1);
    }

    @Test
    public void findStatisticByIdTest() throws NotFoundException {
        Statistic stat = statService.create(new Statistic());
        Statistic actualStat = statService.getStatistic(stat.getId());
        assertNotNull(actualStat);
    }

    @Test
    public void findStatisticByIdNoExistingTest() {
        assertThrowsExactly(NotFoundException.class, () -> {
            Statistic actualStat = statService.getStatistic(-27);
        });
    }

    @Test
    public void findStatisticByNbVues() {
        statService.create(new Statistic(1, 1, 200));
        statService.create(new Statistic(2, 1, 250));
        statService.create(new Statistic(3, 1, 300));
        List<Statistic> stats = statService.list(250);
        assertNotNull(stats);
        assertEquals(1, stats.size());
    }
}
