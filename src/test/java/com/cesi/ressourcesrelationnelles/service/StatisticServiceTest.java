package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
    public void findStatisticByIdTest() {
        Statistic stat = statService.create(new Statistic());
        Statistic actualStat = null;
        try {
            actualStat = statService.getStatistic(stat.getId());
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        assertNotNull(actualStat);
    }

    @Test
    public void findStatisticByIdNoExistingTest() {
        assertThrowsExactly(NotFoundException.class, () -> {
            Statistic actualStat = statService.getStatistic(-27);
        });
    }
}
